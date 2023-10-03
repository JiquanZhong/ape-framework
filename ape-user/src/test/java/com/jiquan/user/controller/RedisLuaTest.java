package com.jiquan.user.controller;

import com.jiquan.user.UserApplication;
import com.jiquan.user.redislua.CompareAndSetLua;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author ZHONG Jiquan
 * @year 2023
 */
@SpringBootTest(classes = {UserApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@Slf4j
public class RedisLuaTest {
	@Resource
	private RedisTemplate redisTemplate;

	@Resource
	private CompareAndSetLua compareAndSetLua;

	@Test
	public void redisLuaTest() {
		ValueOperations<String, Long> opsForValue = redisTemplate.opsForValue();
		opsForValue.set("jiquan", 18L);
		log.info("jiquan的值为：{}", opsForValue.get("jiquan"));

		boolean result = compareAndSetLua.compareAndSet("jiquan", 18L, 19L);
		if(result) {
			log.info("修改成功！jiquan的值为：{}", opsForValue.get("jiquan"));
		}

	}
}