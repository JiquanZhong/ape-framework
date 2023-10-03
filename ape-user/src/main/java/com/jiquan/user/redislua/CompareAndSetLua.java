package com.jiquan.user.redislua;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @author ZHONG Jiquan
 * @year 2023
 */
@Component
@Slf4j
public class CompareAndSetLua {
	@Resource
	private RedisTemplate redisTemplate;

	private DefaultRedisScript<Boolean> casScript;

	@PostConstruct
	public void init(){
		casScript = new DefaultRedisScript<>();
		casScript.setResultType(Boolean.class);
		casScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("lua.compareAndSet.lua")));
	}

	public boolean compareAndSet(String key, Long oldValue, Long newValue){
		ArrayList<Object> keys = new ArrayList<>();
		keys.add(key);
		Boolean result = (Boolean) redisTemplate.execute(casScript, keys, oldValue, newValue);
		return result;
	}
}
