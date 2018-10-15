package com.spring.redis.main.value;

import java.net.URISyntaxException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import com.spring.redis.config.SpringRedisConfig;
import com.spring.redis.model.Employee;

public class SpringRedisExample {
    public static void main(String[] args) throws URISyntaxException, Exception {
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRedisConfig.class);
        try {
            RedisTemplate redisTemplate = (RedisTemplate) ctx.getBean("redisTemplate");
            ValueOperations values = redisTemplate.opsForValue();
            values.set("joe", new Employee("01", "Joe"));

            System.out.println("Employee added: " + values.get("joe"));
        } finally {
            ctx.close();
        }
    }
}
