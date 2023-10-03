package com.jiquan.user.controller;

import com.jiquan.redis.util.CacheUtil;
import com.jiquan.redis.util.RedisShareLockUtil;
import com.jiquan.redis.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @author ZHONG Jiquan
 * @year 2023
 */
@RestController
@Slf4j
@RequestMapping("/test")
public class TestController {
	@Resource
	private RedisUtil redisUtil;

	@Resource
	private RedisShareLockUtil redisShareLockUtil;


	@GetMapping("/testRedis")
	public String testRedis() {
		redisUtil.set("名字", "济全");
		String name = redisUtil.get("名字");
		return name;
	}

	@GetMapping("/testRedisShareLock")
	public String testRedisShareLock() {
		boolean result = redisShareLockUtil.lock("sharedLock", "123456", 10000L);
		log.info("getting shared distributed lock：{}", result);
		return String.valueOf(result);
	}

	@Resource
	private CacheUtil cacheUtil;

	@GetMapping("/testLocalCache")
	public void testLocalCache(List<Long> skuIdList) {
		cacheUtil.getResult(skuIdList, "skuInfo.skuName", SkuInfo.class, (list) -> {
			Map<Long, SkuInfo> skuInfo = getSkuInfo(skuIdList);
			return skuInfo;
		});
		cacheUtil.getResult(skuIdList, "skuInfo.skuPrice", SkuPrice.class, (list) -> {
			Map<Long, SkuPrice> skuPrice = getSkuPrice(skuIdList);
			return skuPrice;
		});
	}

	// 模拟RPC接口(可以使用OpenFeign来作为Service层的RPC调用)
	public Map<Long, SkuInfo> getSkuInfo(List<Long> skuIdList) {
		return Collections.emptyMap();
	}

	public Map<Long, SkuPrice> getSkuPrice(List<Long> skuIdList) {
		return Collections.emptyMap();
	}

	class SkuInfo {
		private Long id;
		private String name;
	}

	class SkuPrice {
		private Long id;
		private Double price;
	}

}
