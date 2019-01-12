package com.mercury.service;

import com.mercury.dataobject.ItemStockDO;
import com.mercury.error.BusinessException;
import com.mercury.service.model.ItemModel;

import java.util.List;

// 商品模型基础模块构成
public interface ItemService {
    // 创建商品
    ItemModel createItem(ItemModel itemModel) throws BusinessException;

    // 商品列表浏览
    List<ItemModel> listItem();

    // 商品详情浏览
    ItemModel getItemById(Integer id);

    ItemStockDO getItemStockById(Integer id);

    // 库存扣除
    boolean decreaseStock(Integer itemId, Integer amount);

    // 增销量
    boolean increaseSales(Integer itemId, Integer amount);

}
