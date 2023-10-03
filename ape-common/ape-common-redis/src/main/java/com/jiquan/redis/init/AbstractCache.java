package com.jiquan.redis.init;

import org.springframework.stereotype.Component;

/**
 * @author ZHONG Jiquan
 * @year 2023
 */
@Component
public abstract class AbstractCache {

	public abstract void initCache();

	public abstract <T> T getCache();

	public abstract void clearCache();

	public void reloadCache(){
		clearCache();
		initCache();
	}
}
