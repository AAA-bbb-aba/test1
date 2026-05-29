package com.hjt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// 类名必须大写开头！！！
@SpringBootApplication
public class app {  // 这里改成 App 大写A
    public static void main(String[] args) {
        SpringApplication.run(app.class, args); // 这里也同步改
    }
}