package com.jiquan.redis.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ZHONG Jiquan
 * @year 2023
 */
@Component
@Slf4j
public class RedisUtil {

	private static final String CACHE_KEY_SEPARATOR=".";

	@Resource
	private RedisTemplate redisTemplate;


	/**
	 * construct the keys with separator
	 * @param strObjs
	 * @return
	 */
	public String buildKey(String... strObjs){
		return Stream.of(strObjs).collect(Collectors.joining(CACHE_KEY_SEPARATOR));
	}

	/**
	 * delete the key
	 * @param key
	 * @return
	 */
	public boolean del(String key){
		return redisTemplate.delete(key);
	}

	/**
	 * set the key if it's absent
	 * @param key
	 * @param value
	 * @param time
	 * @param timeUnit
	 * @return
	 */
	public boolean setNx(String key, String value, Long time, TimeUnit timeUnit){
		return redisTemplate.opsForValue().setIfAbsent(key, value, time, timeUnit);
	}

	public void set(String key, String value) {
		redisTemplate.opsForValue().set(key, value);
	}

	/**
	 * get the value of key
	 * @param key
	 * @return
	 */
	public String get(String key){
		return (String) redisTemplate.opsForValue().get(key);
	}

	/**
	 * get the count number of key
	 * @param key
	 * @return
	 */
	public Long countZset(String key){
		return redisTemplate.opsForZSet().size(key);
	}

	public boolean zadd(String key, Object value, double score){
		return redisTemplate.opsForZSet().add(key, value, score);
	}

	public Set<String> rangeZset(String key, long start, long end){
		return redisTemplate.opsForZSet().range(key, start, end);
	}

	public Long removeZset(String key, Object value) {
		return redisTemplate.opsForZSet().remove(key, value);
	}

	public void removeZsetList(String key, Set<String> value) {
		value.stream().forEach((val) -> redisTemplate.opsForZSet().remove(key, val));
	}

	public Double score(String key, Object value) {
		return redisTemplate.opsForZSet().score(key, value);
	}

	public Set<String> rangeByScore(String key, long start, long end) {
		return redisTemplate.opsForZSet().rangeByScore(key, Double.valueOf(String.valueOf(start)), Double.valueOf(String.valueOf(end)));
	}

	public Object addScore(String key, Object obj, double score) {
		return redisTemplate.opsForZSet().incrementScore(key, obj, score);
	}

	public Object rank(String key, Object obj) {
		return redisTemplate.opsForZSet().rank(key, obj);
	}
}
