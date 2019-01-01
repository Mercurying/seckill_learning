package com.mercury.review.pattern.abstractfacotry;

public class M4Factory implements AbstractFactory {
    @Override
    public Gun produceGun() {
        return new M4();
    }

    @Override
    public Bullet produceBullet() {
        return new M4Bullet();
    }
}
