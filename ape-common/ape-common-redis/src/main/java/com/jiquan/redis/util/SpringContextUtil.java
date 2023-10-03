package com.jiquan.redis.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author ZHONG Jiquan
 * @year 2023
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

	private static ApplicationContext applicationCtxt;

	public static ApplicationContext getApplicationContext(){
		return applicationCtxt;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		applicationCtxt = applicationContext;
	}

	public static Object getBean(Class type){
		return applicationCtxt.getBean(type);
	}
}
