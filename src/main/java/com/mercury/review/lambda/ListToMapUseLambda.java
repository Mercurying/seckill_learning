package com.mercury.review.lambda;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 测试 java 8 lambda表达式以及stream()流式API
 *
 * @author mercury
 * @date 2019/2/22 17:49
 */
public class ListToMapUseLambda {

    private static final Logger logger = LoggerFactory.getLogger(ListToMapUseLambda.class);

    public static void main(String[] args) {
        ListToMapUseLambda instance = new ListToMapUseLambda();
        instance.execute();
    }

    private void execute() {
        List<User> list = initData();
        Map resultMap = getIdNameMap(list);
        logger.info("resultMap:{}", resultMap);
    }

    // 方式一
    private Map<Long, String> getIdNameMap(List<User> userList) {

        return userList.stream().collect(Collectors.toMap(User::getId, User::getUsername));
    }

    // 方式二
    private Map<String, User> getNameUserMap(List<User> userList) {
        return userList.stream().collect(Collectors.toMap(User::getUsername, user -> user));
    }

    // 方式二变种形式
    // 这个方法可能会报错 java.lang.IllegalStateException: Duplicate key
    // 因为name可以是重复的 传入key重复时合并函数解决问题
    private Map<String, User> getNameUserMapPlus(List<User> userList) {
        return userList.stream().collect(Collectors.toMap(User::getUsername, Function.identity(), (key1, key2) -> key2));
    }

    // 方式三指定具体收集的map类型
    private Map<String, User> getNameUserMapPP(List<User> userList) {
        return userList.stream().collect(Collectors.toMap(User::getUsername, Function.identity(),
                (key1, key2) -> key2, LinkedHashMap::new));
    }

    private static List<User> initData() {
        List<User> list = new ArrayList<>();
        User user1 = new User(1L, "张三");
        User user2 = new User(2L, "李四");
        User user3 = new User(3L, "王五");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        return list;
    }

}
