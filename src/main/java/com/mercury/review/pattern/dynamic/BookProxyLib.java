package com.mercury.review.pattern.dynamic;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

// 使用cglib实现代理类
public class BookProxyLib implements MethodInterceptor {
    private Object target;

    // 创建代理类
    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        // 设置回调方法
        enhancer.setCallback(this);
        // 创建代理类
        return enhancer.create();
    }

    // 该方法被执行
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("事务开始...");
        proxy.invokeSuper(obj, args);
        System.out.println("事务结束...");
        return null;

    }
}
