package com.jiquan.redis.util;

import com.jiquan.redis.exception.ShareLockException;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author ZHONG Jiquan
 * @year 2023
 */
@Component
public class RedisShareLockUtil {
	@Resource
	private RedisUtil redisUtil;

	private Long TIME_OUT = 1000L;

	public boolean lock(String lockKey, String requestId, Long time){
		if(StringUtils.isBlank(lockKey) || StringUtils.isBlank(requestId) || time <= 0){
			throw new ShareLockException("Error of shared lock parameters");
		}
		long currentTime = System.currentTimeMillis();
		long outTime = currentTime + TIME_OUT;
		Boolean result = false;
		while(currentTime < outTime){
			result = redisUtil.setNx(lockKey, requestId, time, TimeUnit.MILLISECONDS);
			if(result) return result;

			try{
				Thread.sleep(100);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			currentTime = System.currentTimeMillis();
		}
		return result;
	}

	public boolean unlock(String key, String requestId){
		if(StringUtils.isBlank(key) || StringUtils.isBlank(requestId)){
			throw new ShareLockException("Error of shared lock parameters");
		}
		try {
			String value = redisUtil.get(key);
			if(requestId.equals(value)){
				redisUtil.del(key);
				return true;
			}
		}catch(Exception e){

		}
		return false;
	}

	public boolean tryLock(String lockKey, String requestId, Long time){
		if(StringUtils.isBlank(lockKey) || StringUtils.isBlank(requestId) || time <= 0){
			throw new ShareLockException("Error of shared lock parameters");
		}
		return redisUtil.setNx(lockKey, requestId, time, TimeUnit.MILLISECONDS);
	}
}
