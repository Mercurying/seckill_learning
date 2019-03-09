package com.mercury.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author mercury
 * @date 2019/2/26 22:52
 * <p>
 * spring bean 生命周期示例
 * result:
 * 这是BeanFactoryPostProcessor实现类构造器！！
 * BeanFactoryPostProcessor调用postProcessBeanFactory方法
 * 这是BeanPostProcessor实现类构造器!!!
 * <-- 实例化instantiationAwareBeanPostProcessor对象 -->
 * 【构造器】调用Person的构造器实例化
 * InstantiationAwareBeanPostProcessor调用postProcessPropertyValues方法
 * 【注入属性】注入属性address
 * 【注入属性】注入属性name
 * 【注入属性】注入属性phone
 * 【BeanNameAware接口】调用BeanNameAware.setBeanName()
 * 【BeanFactoryAware接口】调用BeanFactoryAware.setBeanFactory()
 * BeanPostProcessor接口方法postProcessBeforeInitialization对属性进行更改！
 * InstantiationAwareBeanPostProcessor调用postProcessBeforeInstantiation方法
 * 【InitializingBean接口】调用InitializingBean.afterPropertiesSet()
 * 【init-method】调用<bean>的init-method属性指定的初始化方法
 * BeanPostProcessor接口方法postProcessAfterInitialization对属性进行更改！
 * InstantiationAwareBeanPostProcessor调用postProcessAfterInitialization方法
 * 容器初始化成功!
 * Person{name='李四', address='上海', phone='110'}
 * 现在开始关闭容器:...
 * 【DisposableBean接口】调用DisposableBean.destroy()
 * 【destroy-method】调用<bean>的destroy-method属性指定的初始化方法
 */
public class ActiveMain {

    public static void main(String[] args) {
        System.out.println("现在开始初始化容器:");
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        System.out.println("容器初始化成功!");
        Person person = (Person) ctx.getBean("person");
        System.out.println(person.toString());
        System.out.println("现在开始关闭容器:...");
        ((ClassPathXmlApplicationContext) ctx).registerShutdownHook();

    }
}
