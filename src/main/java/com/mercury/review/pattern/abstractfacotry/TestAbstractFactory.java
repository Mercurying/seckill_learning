package com.mercury.review.pattern.abstractfacotry;

// 测试抽象工厂类的调用
// 分为4部进行调用：抽象工厂角色 具体工厂类角色  抽象产品角色 具体产品角色
// 声明枪和子弹接口  具体的类去进行实现
// 统一一个对外暴露的抽象工厂接口  具体产品去实现 然后在去调用具体产品即可
public class TestAbstractFactory {
    public static void main(String[] args) {
        System.out.println("=============测试抽象工厂类调用使用=============");
        AbstractFactory factory;
        Gun gun;
        Bullet bullet;
        factory = new AKFactory();
        gun = factory.produceGun();
        gun.shotting();
        bullet = factory.produceBullet();
        bullet.loading();
    }
}
