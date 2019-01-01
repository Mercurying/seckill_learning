package com.mercury.review.pattern.decorator;


/*Decorator 抽象装饰类*/
public class Decorator implements Person {

    protected Person person;

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public void eat() {
        person.eat();
    }
}
