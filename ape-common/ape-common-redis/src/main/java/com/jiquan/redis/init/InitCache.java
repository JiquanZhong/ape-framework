package com.jiquan.redis.init;

import com.jiquan.redis.util.SpringContextUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author ZHONG Jiquan
 * @year 2023
 */
@Component
@ConditionalOnProperty(name = {"init.cache.enable"}, havingValue = "true")
public class InitCache implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
		ApplicationContext applicationContext = SpringContextUtil.getApplicationContext();
		Map<String, AbstractCache> beanMap = applicationContext.getBeansOfType(AbstractCache.class);

		if(!beanMap.isEmpty()){
			for(Map.Entry<String, AbstractCache> entry : beanMap.entrySet()){
				AbstractCache abstractCache = (AbstractCache) SpringContextUtil.getBean(entry.getValue().getClass());
				abstractCache.initCache();
			}
		}

		System.out.println("succeed in loading all caches");
	}
}
