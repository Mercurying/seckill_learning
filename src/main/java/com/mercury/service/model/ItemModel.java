package com.mercury.service.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ItemModel {
    private Integer id;

    // 商品名称
    @NotBlank(message = "商品名称不能为空!")
    private String title;
    // 商品价格
    @NotNull(message = "商品价格不能不填写!")
    @Min(value = 0, message = "商品价格必须大于0")
    private BigDecimal price;
    // 商品库存
    @NotNull(message = "商品库存不能为空!")
    @Min(value = 0, message = "商品库存必须大于0")
    private Integer stock;
    // 商品描述
    @NotBlank(message = "商品描述信息不能不填写!")
    private String description;
    // 商品图片的url
    @NotBlank(message = "商品图片信息url不能不填写!")
    private String imgUrl;
    // 商品销售量
    private Integer sales;

    // 添加秒杀活动信息
    private PromoModel promoModel;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public PromoModel getPromoModel() {
        return promoModel;
    }

    public void setPromoModel(PromoModel promoModel) {
        this.promoModel = promoModel;
    }

    @Override
    public String toString() {
        return "ItemModel{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", description='" + description + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", sales=" + sales +
                ", promoModel=" + promoModel +
                '}';
    }
}
