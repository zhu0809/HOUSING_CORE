package com.bs.housing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HousingApplicationTests {

    @Autowired
    RedisConnectionFactory factory;

    @Test
    public void contextLoads() {
        System.out.println(factory);
		RedisConnection conn = factory.getConnection();
		conn.set("hello".getBytes(), "world".getBytes());
		System.out.println(new String(conn.get("hello".getBytes())));
    }

}
