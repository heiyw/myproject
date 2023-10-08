package com.nowcoder.community;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class RedisTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testStrings(){
        String redisKey = "test:count";
        //添加
        redisTemplate.opsForValue().set(redisKey,1);
        //获取
        redisTemplate.opsForValue().get(redisKey);
        //增加
        redisTemplate.opsForValue().increment(redisKey);
        //减少
        redisTemplate.opsForValue().decrement(redisKey);
    }
}
