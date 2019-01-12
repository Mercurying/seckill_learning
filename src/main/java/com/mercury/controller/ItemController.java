package com.mercury.controller;


import com.mercury.controller.voobject.ItemVO;
import com.mercury.dataobject.ItemStockDO;
import com.mercury.error.BusinessException;
import com.mercury.error.EnumBusinessError;
import com.mercury.response.CommonReturnType;
import com.mercury.service.ItemService;
import com.mercury.service.model.ItemModel;
import com.mercury.service.model.UserModel;
import org.joda.time.format.DateTimeFormat;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("item/")
@CrossOrigin(allowCredentials = "true", allowedHeaders = {"*"})
public class ItemController extends BaseController {

    @Autowired
    private ItemService itemService;
    @Autowired
    private HttpServletRequest httpServletRequest;


    // 新建添加商品信息
    @RequestMapping(value = "create", method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType createItem(@RequestParam(value = "title") String title,
                                       @RequestParam(value = "price") BigDecimal price,
                                       @RequestParam(value = "description") String description,
                                       @RequestParam(value = "stock") Integer stock,
                                       @RequestParam(value = "imgUrl", defaultValue = "https://www.mercury.com/girls.png") String imgUrl
    ) throws BusinessException {
        // 添加用户是否登录状态判断 若未登录则提示无权限操作
        UserModel user = (UserModel) this.httpServletRequest.getSession().getAttribute(BaseController.CURRENT_USER);
        if (user == null) {
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR, "用户未登录,请登录后进行操作");
        }
        System.out.println("当前登录系统用户是:");
        System.out.println(user);

        ItemModel itemModel = new ItemModel();
        itemModel.setTitle(title);
        itemModel.setPrice(price);
        itemModel.setDescription(description);
        itemModel.setStock(stock);
        itemModel.setImgUrl(imgUrl);
        ItemModel createResult = itemService.createItem(itemModel);
        ItemVO itemVO = this.convertItemVOFromItemModel(createResult);
        return CommonReturnType.create(itemVO);
    }


    // 获取商品详情
    @RequestMapping(value = "getItemById", method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType getItemById(@RequestParam(value = "id") Integer id) throws BusinessException {

        UserModel user = (UserModel) this.httpServletRequest.getSession().getAttribute(BaseController.CURRENT_USER);
        if (user == null) {
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR, "用户未登录,请登录后进行操作");
        }
        if (id == null) {
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR);
        }
        ItemModel itemModel = itemService.getItemById(id);
        ItemVO itemVO = this.convertItemVOFromItemModel(itemModel);
        return CommonReturnType.create(itemVO);
    }

    // 获取商品列表页 暂时未使用分页进行操作
    @RequestMapping(value = "list", method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType listItem() {

        List<ItemModel> itemModelList = itemService.listItem();
        List<ItemVO> itemVOList = itemModelList.stream().map(itemModel -> {
            ItemVO itemVO = this.convertItemVOFromItemModel(itemModel);
            return itemVO;
        }).collect(Collectors.toList());

        return CommonReturnType.create(itemVOList);
    }


    // 测试使用ItemStockDOMapper 接口使用
    @RequestMapping(value = "getItemStockById", method = {RequestMethod.GET})
    @ResponseBody
    public CommonReturnType getItemStockById(@RequestParam(value = "id") Integer id) {

        // 测试ItemStockDOMapper 对应的接口是否正常
        // 由于对应的ItemStockDOMapper.xml 文件中对应的id 自动生成时变成了" id"
        ItemStockDO itemStockDO = itemService.getItemStockById(id);
        return CommonReturnType.create(itemStockDO);
    }


    // 统一组装返回给前端展示的ItemVO对象
    private ItemVO convertItemVOFromItemModel(ItemModel itemModel) {
        if (itemModel == null) {
            return null;
        }
        ItemVO itemVO = new ItemVO();
        BeanUtils.copyProperties(itemModel, itemVO);
        if (itemModel.getPromoModel() != null) {
            // 存在秒杀活动 --未开始 正在进行中
            itemVO.setPromoStatus(itemModel.getPromoModel().getStatus());
            itemVO.setPromoPrice(itemModel.getPromoModel().getPromoItemPrice());
            itemVO.setPromoStartDate(itemModel.getPromoModel().getStartDate().toString(DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")));
            itemVO.setPromoId(itemModel.getPromoModel().getId());
        } else {
            // 没有秒杀活动
            itemVO.setPromoStatus(0);
        }

        return itemVO;
    }


}
