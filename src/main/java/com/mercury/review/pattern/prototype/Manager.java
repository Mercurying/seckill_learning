package com.mercury.review.pattern.prototype;

import java.util.HashMap;

/**
 * 使用Product进行复制实例
 */
public class Manager {
    // 保存实例的名称与实例之间对应的关系
    private HashMap<String, Product> showcase = new HashMap<String, Product>();

    // register方法将接收到一组"名字" 和"Product接口" 注册到showcase中
    // 这里Product是实现Product接口的实例
    public void register(String name, Product product) {
        showcase.put(name, product);
    }

    public Product create(String productName) {
        Product p = showcase.get(productName);
        return p.createClone();
    }
}
