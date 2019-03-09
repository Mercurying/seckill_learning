package com.mercury.review;

/**
 * java流共涉及到40多个类
 * java IO基础知识
 * IO NIO jdk 1.4 后退出 N non-blocking
 * 区别：IO是面向流的 NIO是面向缓冲区的
 * IO流式阻塞的 NIO是非阻塞的
 * NIO有选择器 IO没有该特性  Channels Buffers Selectors
 * 字符流  字节流
 * 输入流 输出流
 * 节点流 处理流
 * Writer Reader  InputStream  OutPutStream
 * InputStream/Reader 所有流入流的基类
 * OutPutStream/Writer 所有流出流的基类
 */
public class JavaIO {
    private static final Character a = 'B';

    public static void main(String[] args) {
        System.out.printf("0.1*3=0.3 是否正确:%s", (0.1 * 3 == 0.3));
    }

}
