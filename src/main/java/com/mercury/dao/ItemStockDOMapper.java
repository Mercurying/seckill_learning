package com.mercury.dao;

import com.mercury.dataobject.ItemStockDO;
import org.apache.ibatis.annotations.Param;

public interface ItemStockDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_stock
     *
     * @mbggenerated Sat Jan 12 14:23:26 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_stock
     *
     * @mbggenerated Sat Jan 12 14:23:26 CST 2019
     */
    int insert(ItemStockDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_stock
     *
     * @mbggenerated Sat Jan 12 14:23:26 CST 2019
     */
    int insertSelective(ItemStockDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_stock
     *
     * @mbggenerated Sat Jan 12 14:23:26 CST 2019
     */
    ItemStockDO selectByPrimaryKey(Integer id);

    ItemStockDO selectByItemId(Integer itemId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_stock
     *
     * @mbggenerated Sat Jan 12 14:23:26 CST 2019
     */
    int updateByPrimaryKeySelective(ItemStockDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table item_stock
     *
     * @mbggenerated Sat Jan 12 14:23:26 CST 2019
     */
    int updateByPrimaryKey(ItemStockDO record);

    // 传递多参数必须使用@Param注解标注
    int decreaseStock(@Param(value = "itemId") Integer itemId, @Param(value = "amount") Integer amount);
}