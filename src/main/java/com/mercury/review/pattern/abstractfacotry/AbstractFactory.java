package com.mercury.review.pattern.abstractfacotry;

/**
 * 对外提供统一的生产枪和子弹的抽象工厂类
 */
public interface AbstractFactory {
    Gun produceGun();

    Bullet produceBullet();
}
