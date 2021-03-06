package com.mercury.service.impl;

import com.mercury.dao.UserDOMapper;
import com.mercury.dao.UserPasswordDOMapper;
import com.mercury.dataobject.UserDO;
import com.mercury.dataobject.UserPasswordDO;
import com.mercury.error.BusinessException;
import com.mercury.error.EnumBusinessError;
import com.mercury.service.UserService;
import com.mercury.service.model.UserModel;
import com.mercury.validator.ValidationResult;
import com.mercury.validator.ValidatorImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDOMapper userDOMapper;
    @Autowired
    private UserPasswordDOMapper userPasswordDOMapper;
    @Autowired
    private ValidatorImpl validator;


    @Override
    public UserModel getUserById(Integer id) {
        UserDO userDO = userDOMapper.selectByPrimaryKey(id);
        UserPasswordDO userPasswordDO = userPasswordDOMapper.selectByUserId(id);
        return assembleUserModel(userDO, userPasswordDO);

    }

    // 保证是事务性操作  优化校验规则
    @Transactional
    @Override
    public void register(UserModel userModel) throws BusinessException {
        if (userModel == null) {
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        }
//        if (StringUtils.isEmpty(userModel.getName())
//                || userModel.getAge() == null
//                || userModel.getGender() == null
//                || StringUtils.isEmpty(userModel.getTelphone())) {
//            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
//        }
        // 使用自定义的验证规则进行验证前端传递的必要参数是否合法 使用注解在对应model上进行注释
        ValidationResult result = validator.validate(userModel);
        if (result.getHasErrors()) {
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR, result.getErrorMsg());
        }


        // 添加用户基本信息
        UserDO userDO = convertFromUserModel(userModel);
        try {
            userDOMapper.insertSelective(userDO);
        } catch (DuplicateKeyException ex) {
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR, "手机号码已注册.");
        }
        // 从插入数据库中的userDO获取userId   但是必须修改UserDOMapper.xml keyProperty及useGeneratedKeys
        userModel.setId(userDO.getId());
        // 添加用户密码信息
        UserPasswordDO userPasswordDO = convertForUserPasswordDO(userModel);
        userPasswordDOMapper.insertSelective(userPasswordDO);


    }

    @Override
    public UserModel login(String telphone, String encryptedPassword) throws BusinessException {

        if (StringUtils.isEmpty(telphone) || StringUtils.isEmpty(encryptedPassword)) {
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        UserDO userDO = userDOMapper.selectByTelphone(telphone);
        if (userDO == null) {
            throw new BusinessException(EnumBusinessError.USER_NOT_EXIST);
        }
        UserPasswordDO userPasswordDO = userPasswordDOMapper.selectByUserIdPassword(userDO.getId(), encryptedPassword);

        if (userPasswordDO == null) {
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR, "密码错误,请重新输入.");
        }
        UserModel userModel = assembleUserModel(userDO, userPasswordDO);
        return userModel;
    }

    /**
     * 三条执行sql的语句第一条执行成功中间那一条执行失败
     * 第三条是不会进行执行的
     */
    // rollbackFor = IllegalArgumentException.class
    // 前几次之所以没有生效是由于数据表存储引擎设置的是innoDB导致的 innoDB不支持事务
    @Transactional
    @Override
    public void testWithOutTransactionCondition(UserDO userDO, String password) {
        //
        userDOMapper.insertSelective(userDO);
      //  throw new IllegalArgumentException("参数不合法");
        insertWithException(userDO, password);

    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void insertWithException(UserDO userDO, String password) {
        UserPasswordDO userPasswordDO = new UserPasswordDO();
        userPasswordDO.setUserId(5);
        userPasswordDO.setEncryptedPassword(password);
        userPasswordDOMapper.insertSelective(userPasswordDO);

    }


    // 将userModel对象转换成数据库需要的dataobject类型
    private UserDO convertFromUserModel(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        UserDO userDO = new UserDO();
        BeanUtils.copyProperties(userModel, userDO);
        return userDO;
    }

    private UserPasswordDO convertForUserPasswordDO(UserModel userModel) {
        if (userModel == null) {
            return null;
        }
        UserPasswordDO userPasswordDO = new UserPasswordDO();
        userPasswordDO.setEncryptedPassword(userModel.getEncryptedPassword());
        userPasswordDO.setUserId(userModel.getId());
        return userPasswordDO;
    }

    // 将dataobject对象转换成model领域模型对象
    private UserModel assembleUserModel(UserDO userDO, UserPasswordDO userPasswordDO) {
        UserModel userModel = new UserModel();
        if (userDO == null) {
            return null;
        }
        BeanUtils.copyProperties(userDO, userModel);
        if (userPasswordDO != null) {
            userModel.setEncryptedPassword(userPasswordDO.getEncryptedPassword());
        }
        return userModel;
    }
}
