package com.mercury.review.pattern.proxy;

/**
 * 设计模式之代理模式：
 * 代理角色：主题接口 真实主题  代理类 Main 客户端 使用代理类和主题接口完成一些工作
 * 代理作用:
 * 延迟加载  IDBQuery -- 主题接口  DBQuery --真实主题   DBQueryProxy 代理类
 * 测试通过DBQueryProxy 模拟数据库连接时的延时加载
 * <p>
 * 代理模式应用：
 * 远程代理 为一个对象在不同的地址空间提供局部的代表 这样就可以隐藏一个对象于不同地址空间的事实.
 * 虚拟代理 是根据需要创建开销很大的对象 通过它来存放实例化需要很长时间的真实对象
 * 安全代理 控制真实对象的访问权限
 * 指针引用
 * 延迟加载
 */
public class TestProxy {
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println("连接数据库...开始查询数据:" + startTime);
        IDBQuery query = new DBQueryProxy();
        String queryResult = query.request();
        long endTime = System.nanoTime();
        System.out.println("本次查询所耗费时间是:" + (endTime - startTime));
        System.out.println(queryResult);
    }
}
