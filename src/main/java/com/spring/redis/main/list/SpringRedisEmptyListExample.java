package com.spring.redis.main.list;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.BooleanUtils;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import com.spring.redis.config.SpringRedisConfig;

public class SpringRedisEmptyListExample {
    public static void main(String[] args) throws URISyntaxException, Exception {
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRedisConfig.class);
        try {
            RedisTemplate redisTemplate = (RedisTemplate) ctx.getBean("redisTemplate");
            List<Long> listData = new ArrayList<>();
            String redisKey = "Test-List-Empty";
            if (BooleanUtils.isFalse(redisTemplate.hasKey(redisKey))) {
                redisTemplate.opsForList().rightPushAll(redisKey, listData);
                redisTemplate.expire(redisKey, 5, TimeUnit.HOURS);
            }

            for (int i = 0; i < listData.size() + 5; i++) {
                Long dataId = (Long) redisTemplate.opsForList().leftPop(redisKey);
                System.out.println("Redis data is :: " + dataId);
            }

        } finally {
            ctx.close();
        }
    }
}
