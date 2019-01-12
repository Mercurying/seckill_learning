package com.mercury.controller;


import com.mercury.controller.voobject.OrderVO;
import com.mercury.error.BusinessException;
import com.mercury.error.EnumBusinessError;
import com.mercury.response.CommonReturnType;
import com.mercury.service.OrderService;
import com.mercury.service.model.OrderModel;
import com.mercury.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("order/")
@CrossOrigin(allowCredentials = "true", allowedHeaders = {"*"})
public class OrderController extends BaseController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private HttpServletRequest httpServletRequest;


    // 创建订单接口
    @RequestMapping(value = "create", method = {RequestMethod.POST})
    @ResponseBody
    public CommonReturnType createOrder(@RequestParam(value = "itemId") Integer itemId,
                                        @RequestParam(value = "promoId", required = false) Integer promoId,
                                        @RequestParam(value = "amount") Integer amount
    ) throws BusinessException {

        UserModel user = (UserModel) httpServletRequest.getSession().getAttribute(BaseController.CURRENT_USER);
        if (user == null) {
            throw new BusinessException(EnumBusinessError.PARAMETER_VALIDATION_ERROR, "用户未登录,请登录后进行操作");
        }
        OrderModel orderModel = orderService.createOrder(user.getId(), itemId, promoId, amount);
        OrderVO orderVO = this.convertOrderVOFromOrderModel(orderModel);
        return CommonReturnType.create(orderVO);
    }


    private OrderVO convertOrderVOFromOrderModel(OrderModel orderModel) {
        if (orderModel == null) {
            return null;
        }
        OrderVO orderVO = new OrderVO();
        BeanUtils.copyProperties(orderModel, orderVO);
        return orderVO;
    }

}
