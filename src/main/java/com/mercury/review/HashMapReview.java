package com.mercury.review;

/*复习HashMap的基础知识点*/

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author mercury
 * @version v1.0
 * @description HashMap 实现 基于哈希表的Map接口
 * 底层数据结构 jdk1.8 之前 数组+链表  jdk1.8之后 未达到阈值之前 数组+链表  达到阈值之后链表转换为红黑树
 * 加快搜索时间
 * key可以为null 仅且只有一个为null value可以多个null值
 * @date 2018/12/27 20:54
 */
public class HashMapReview {

    public static void main(String[] args) {

        HashMapReview.hashMapDemo();
    }

    private static void hashMapDemo() {
        System.out.println("=====开始测试hashMapDemo=====");
        HashMap<String, String> map = new HashMap<String, String>();
        map.put(null, "null值");
        map.put("张三", null);
        map.put("李四", "李四value");
        map.put("李四", "我叫李四");
        map.put("老王", null);
        System.out.println("====输出map====");
        System.out.println(map);
        // 遍历map
        System.out.println("forEach遍历获取到所有的keys:");
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            System.out.print(key + " ");
        }
        System.out.println();
        // 获取map中的所有值
        System.out.println("forEach遍历获取到所有的values:");
        Collection<String> values = map.values();
        for (String value : values) {
            System.out.print(value + " ");
        }
        System.out.println();

        System.out.println("获取到key以及对应的value值:");
        for (String key : keySet) {
            System.out.println("key=" + key + "& values=" + map.get(key));
        }

        System.out.println("====其他遍历方式====");
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println("key=" + entry.getKey() + "&value=" + entry.getValue());
        }


    }
}
