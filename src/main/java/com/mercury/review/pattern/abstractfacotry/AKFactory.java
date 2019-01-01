package com.mercury.review.pattern.abstractfacotry;

public class AKFactory implements AbstractFactory {
    @Override
    public Gun produceGun() {
        return new AK();
    }

    @Override
    public Bullet produceBullet() {
        return new AKBullet();
    }
}
