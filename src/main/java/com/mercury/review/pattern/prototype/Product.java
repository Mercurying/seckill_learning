package com.mercury.review.pattern.prototype;

/**
 * 必须实现 java.lang.Cloneable 接口 只有实现 改接口的实例才能调用clone() 否则会抛出异常：
 */
public interface Product extends Cloneable {
    // use方法是用于"使用"的方法 具体怎么使用 交给具体子类去实现
    public abstract void use(String s);

    // createClone() 是用于复制实例的方法
    public abstract Product createClone();

}
