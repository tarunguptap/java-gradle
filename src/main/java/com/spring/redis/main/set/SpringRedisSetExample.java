package com.spring.redis.main.set;

import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.BooleanUtils;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

import com.spring.redis.config.SpringRedisConfig;

// TODO:Need to see how we can pop single item from set

public class SpringRedisSetExample {
    public static void main(String[] args) throws URISyntaxException, Exception {
        ConfigurableApplicationContext ctx = new AnnotationConfigApplicationContext(SpringRedisConfig.class);
        try {
            RedisTemplate redisTemplate = (RedisTemplate) ctx.getBean("redisTemplate");
            Set<Long> setData = new HashSet<Long>();

            String redisKey = "Test-List";
            setData.add(1111l);
            setData.add(2222l);
            setData.add(3333l);
            setData.add(4444l);
            setData.add(5555l);
            setData.add(6666l);
            setData.add(7777l);
            if (BooleanUtils.isFalse(redisTemplate.hasKey(redisKey))) {
                redisTemplate.opsForSet().add(redisKey, setData);
                // To set the expiry time for redis key
                redisTemplate.expire(redisKey, 5, TimeUnit.HOURS);
            }
            // This code piece shows that if same list is persisted multiple time then redis will have the duplicate
            // values. So the code block at line number 29, for multi-threaded environment will push the duplicates to
            // the list
            redisTemplate.opsForSet().add(redisKey, setData);

            for (int i = 0; i < setData.size() * 2; i++) {
                // Long dataId = (Long) redisTemplate.boundSetOps(redisKey);
                // System.out.println("Redis data is :: " + dataId);
            }

        } finally {
            ctx.close();
        }
    }
}
