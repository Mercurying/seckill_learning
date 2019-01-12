package com.mercury.controller;

import com.mercury.controller.voobject.UserVO;
import com.mercury.error.BusinessException;
import com.mercury.error.EnumBusinessError;
import com.mercury.response.CommonReturnType;
import com.mercury.service.UserService;
import com.mercury.service.model.UserModel;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Encoder;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

// 该设置针对ajax跨域请求
/*使用CrossOrigin进行跨域请求设置放行 需添加 allowCredentials  allowedHeaders 设置*/
@Controller
@RequestMapping("user/")
@CrossOrigin(allowCredentials = "true", allowedHeaders = {"*"})
public class UserController extends BaseController {
    @Autowired
    private UserService userService;
    @Autowired
    private HttpServletRequest httpServletRequest;


    /*用户获取otp登录验证码 on-time password */
    @RequestMapping(value = "getOtp", method = {RequestMethod.POST}, consumes = {BaseController.CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType getOtp(@RequestParam(value = "telphone") String telphone) {

        // 需要按照一定的规则生成otp验证码
        Random random = new Random();
        // 范围是[0,99999)
        int randomInt = random.nextInt(99999);
        // 范围是[10000,109999)
        randomInt += 10000;
        String otpCode = String.valueOf(randomInt);
        // 将otp验证码同对应用户的手机号码相关联 实际企业级开发中应该使用redis进行关联 现在使用HTTPSession进行关联
        // 注意此处将HttpServletRequest进行注入 注入此时的声明周期 当并发情况 默认通过依赖注入的beans都是单例模式
        // spring  beans已经进行过处理 可以放心使用  并发亦可以使用 可以对应当前用户
        httpServletRequest.getSession().setAttribute(telphone, otpCode);

        // 将otp验证码通过短信通道发送给用户 暂时省略[实际情形应对接短信发送接口将otpCode码发送给用户]
        // 企业中禁止将用户敏感信息暴露出
        System.out.println("telphone=" + telphone + "&otpCode=" + otpCode);

        return CommonReturnType.create("短信验证码已发送,请注意查收!");
    }

    // 用户注册接口
    @RequestMapping(value = "register", method = {RequestMethod.POST}, consumes = {BaseController.CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType register(@RequestParam(value = "telphone") String telphone,
                                     @RequestParam(value = "otpCode") String otpCode,
                                     @RequestParam(value = "name") String name,
                                     @RequestParam(value = "gender") Integer gender,
                                     @RequestParam(value = "age") Integer age,
                                     @RequestParam(value = "password") String password) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        String inSessionOtpCode = (String) this.httpServletRequest.getSession().getAttribute(telphone);
        if (!StringUtils.equals(otpCode, inSessionOtpCode)) {
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR, "短信验证码不正确.");
        }
        // 年龄类型   Byte-->解决方式将Byte类型强制设置为Integer类型
        UserModel userModel = new UserModel();
        userModel.setName(name);
        // 将Integer类型强转为Byte类型 new Byte(String.valueOf(gender.intValue()))
        userModel.setGender(gender.byteValue());
        userModel.setAge(age);
        userModel.setTelphone(telphone);
        userModel.setRegisterMode("byphone");
        userModel.setEncryptedPassword(this.encodeByMd5(password));
        userService.register(userModel);
        Map<String, String> result = new HashMap<>();
        result.put("msg", "注册成功，恭喜您:您已成为本站VIP.");
        return CommonReturnType.create(result);
    }

    // 登录接口
    @RequestMapping(value = "login", method = {RequestMethod.POST}, consumes = {BaseController.CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType login(@RequestParam(value = "telphone") String telphone,
                                  @RequestParam(value = "password") String password) throws UnsupportedEncodingException, NoSuchAlgorithmException, BusinessException {

        UserModel userModel = userService.login(telphone, this.encodeByMd5(password));
        // 登录成功之后应该将加密后的密码进行清空
        userModel.setEncryptedPassword(StringUtils.EMPTY);
        this.httpServletRequest.getSession().setAttribute(BaseController.CURRENT_USER, userModel);
        UserVO userVO = this.assembleUserVO(userModel);
        return CommonReturnType.create(userVO);
    }

    // 登出接口
    @RequestMapping(value = "logout", method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType logout() {
        this.httpServletRequest.getSession().removeAttribute(BaseController.CURRENT_USER);
        return CommonReturnType.create("登出成功");
    }


    // 通过用户id查询用户接口
    @RequestMapping(value = "get", method = RequestMethod.GET)
    @ResponseBody
    public CommonReturnType getUserById(@RequestParam(value = "id") Integer id) throws BusinessException {
        // 判断用户是已登录系统
        UserModel user = (UserModel) this.httpServletRequest.getSession().getAttribute(BaseController.CURRENT_USER);
        if (user == null) {
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR, "用户未登录,请登录后查看信息");
        }
        UserModel userModel = userService.getUserById(id);
        // 主动抛出异常
        if (userModel == null) {
            throw new BusinessException(EnumBusinessError.USER_NOT_EXIST);
        }

        UserVO userVO = assembleUserVO(userModel);
        return CommonReturnType.create(userVO);
    }

    // 在前端传递参数时不一定必须要按照这个书写顺序传递参数 即可以使用 age name gender 顺序进行传递参数
    // 但是不传递参数或者是缺少参数一定是会报错的
    // 错误提示信息:Required Integer parameter 'age' is not present
    @RequestMapping(value = "testParamsOrder", method = {RequestMethod.POST}, consumes = {BaseController.CONTENT_TYPE_FORMED})
    @ResponseBody
    public CommonReturnType testParamsOrder(@RequestParam(value = "name") String name,
                                            @RequestParam(value = "age") Integer age,
                                            @RequestParam(value = "gender") Integer gender) throws BusinessException {

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("name", name);
        resultMap.put("age", age);
        resultMap.put("gender", gender);
        return CommonReturnType.create(resultMap);
    }

    /*组装返回前端所需的数据*/
    private UserVO assembleUserVO(UserModel userModel) {
        UserVO userVO = new UserVO();
        if (userModel == null) {
            return null;
        }
        BeanUtils.copyProperties(userModel, userVO);
        return userVO;
    }

    // md5加密实现
    private String encodeByMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64Encoder = new BASE64Encoder();
        String newStr = base64Encoder.encode(md5.digest(str.getBytes("utf-8")));
        return newStr;
    }

    public static void main(String[] args) {
        UserController userController = new UserController();
        try {
            String encryptedPwd = userController.encodeByMd5("mukewang123456");
            System.out.println("encryptedPwd:" + encryptedPwd);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }


}
