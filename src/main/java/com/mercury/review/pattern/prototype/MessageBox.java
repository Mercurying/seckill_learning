package com.mercury.review.pattern.prototype;

public class MessageBox implements Product {
    // 装饰方框使用的字符样式
    private char decoChar;

    public MessageBox(char decoChar) {
        this.decoChar = decoChar;
    }

    @Override
    public void use(String s) {
        int length = s.getBytes().length;
        for (int i = 0; i < length + 4; i++) {
            System.out.print(decoChar);
        }
        System.out.println("");
        System.out.println(decoChar + "" + s + "" + decoChar);
        for (int i = 0; i < length + 4; i++) {
            System.out.println(decoChar);
        }
        System.out.println("");
    }

    // 使用该方法进行复制自己本身
    // 只有类自己（或是它的子类）能够调用java语言中定义的clone方法。当其他类要求复制实例时
    // 必须先调用createCone() 这样的方法 然后在该方法内部在调用clone()方法.
    @Override
    public Product createClone() {
        Product p = null;
        try {
            p = (Product) clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
