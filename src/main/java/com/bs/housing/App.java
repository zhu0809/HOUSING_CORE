package com.bs.housing;

import com.bs.housing.core.context.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching//标识开始缓存
public class App {

    public static void main(String[] args) {
        ApplicationContext.context = SpringApplication.run(App.class, args);
    }
}
