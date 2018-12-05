package com.bs.housing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;

@SpringBootApplication
@EnableCaching//标识开始缓存
public class App {
    public static ConfigurableApplicationContext CONTEXT = null;

    public static void main(String[] args) {
        CONTEXT = SpringApplication.run(App.class, args);
    }
}
