package com.mercury.review;


/**
 * 复习Servlet的基础知识
 * servlet的基础概念
 * java web中的作用  httpServletRequest
 * 转发forward与redirect重定向区别
 * forward是服务端行为  redirect是客户端行为
 * forward可以在两个页面之间进行共享 request  redirect不行
 * forward表现在URL地址栏上来说:地址栏地址不会发生变化  redirect地址栏地址会发生变化
 * redirect利用服务器返回的状态码进行实现  浏览器根据服务器返回的状态码去重新请求地址
 * forward一般用于用户登录的时候：根据角色权限跳转到对应的页面
 * redirect一般用户用户注销登录时返回主页面和跳转到其他页面时使用
 * jsp与servlet之间的关系  jsp本质上是servlet的简易形式
 */
public class ServletReview {

    public static void main(String[] args) {

    }
}
