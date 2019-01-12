package com.mercury.controller.voobject;

import java.math.BigDecimal;

public class ItemVO {

    private Integer id;
    // 商品名称
    private String title;
    // 商品价格
    private BigDecimal price;
    // 商品库存
    private Integer stock;
    // 商品描述
    private String description;
    // 商品图片的url
    private String imgUrl;
    // 商品销售量
    private Integer sales;
    // 秒杀活动状态 0:没有秒杀活动 1:秒杀活动未开始 2:秒杀活动正在进行中
    private Integer promoStatus;
    // 秒杀活动价格
    private BigDecimal promoPrice;
    // 秒杀活动开始时间 --用于倒计时
    private String PromoStartDate;
    // 秒杀活动id
    private Integer promoId;

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

    public Integer getPromoStatus() {
        return promoStatus;
    }

    public void setPromoStatus(Integer promoStatus) {
        this.promoStatus = promoStatus;
    }

    public BigDecimal getPromoPrice() {
        return promoPrice;
    }

    public void setPromoPrice(BigDecimal promoPrice) {
        this.promoPrice = promoPrice;
    }

    public String getPromoStartDate() {
        return PromoStartDate;
    }

    public void setPromoStartDate(String promoStartDate) {
        this.PromoStartDate = promoStartDate;
    }

    public Integer getPromoId() {
        return promoId;
    }

    public void setPromoId(Integer promoId) {
        this.promoId = promoId;
    }
}
