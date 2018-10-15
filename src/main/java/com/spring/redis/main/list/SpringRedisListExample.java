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

public class SpringRedisListExample {
    public static void main(String[] args) throws URISyntaxException, Exception {
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRedisConfig.class);
        try {
            RedisTemplate redisTemplate = (RedisTemplate) ctx.getBean("redisTemplate");
            List<Long> listData = new ArrayList<>();
            String redisKey = "Test-List";
            listData.add(1111l);
            listData.add(2222l);
            listData.add(3333l);
            listData.add(4444l);
            listData.add(5555l);
            listData.add(6666l);
            listData.add(7777l);
            if (BooleanUtils.isFalse(redisTemplate.hasKey(redisKey))) {
                redisTemplate.opsForList().leftPushAll(redisKey, listData);
                // To set the expiry time for redis key
                redisTemplate.expire(redisKey, 5, TimeUnit.HOURS);
            }
            // This code piece shows that if same list is persisted multiple time then redis will have the duplicate
            // values. So the code block at line number 29, for multi-threaded environment will push the duplicates to
            // the list
            redisTemplate.opsForList().leftPushAll(redisKey, listData);

            for (int i = 0; i < listData.size() * 2; i++) {
                Long dataId = (Long) redisTemplate.opsForList().leftPop(redisKey);
                System.out.println("Redis data is :: " + dataId);
            }

        } finally {
            ctx.close();
        }
    }
}
