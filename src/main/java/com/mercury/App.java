package com.mercury;

import com.mercury.dao.UserDOMapper;
import com.mercury.dataobject.UserDO;
import com.mercury.error.EnumBusinessError;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author mercury
 * @version v1.0
 * @description spring boot 项目实战
 * 使用注解@EnableAutoConfiguration 启动spring boot的自动配置项目
 * 无需使用xml文件进行配置
 * SpringApplication.run() 启动spring boot
 * 准备继承myBatis插件
 * 使用@SpringBootApplication 将采用spring boot来托管App类
 * 还有一个注解是@EnableAutoConfiguration
 * 使用@MapperScan注解将mybatis beans进行注入
 * @date 2018/12/22 17:09
 */

@SpringBootApplication(scanBasePackages = {"com.mercury"})
@RestController
@MapperScan("com.mercury.dao")
public class App {
    // 测试DI 自动依赖注入是否成功
    @Autowired
    private UserDOMapper userDOMapper;

    @RequestMapping("/")
    public String hello() {

        UserDO userDO = userDOMapper.selectByPrimaryKey(1);
        if (userDO == null) {
            return EnumBusinessError.USER_NOT_EXIST.getErrorMsg();
        } else {
            return userDO.getName();
        }

    }

    public static void main(String[] args) {
        // 启动spring boot
        SpringApplication.run(App.class, args);
    }
}
