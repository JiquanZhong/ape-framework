package com.jiquan.config;

import com.jiquan.inteceptor.SqlBeautyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZHONG Jiquan
 * @year 2023
 */
@Configuration
public class MybatisConfiguration {

	@Bean
	public SqlBeautyInterceptor sqlBeautyInterceptor(){
		return new SqlBeautyInterceptor();
	}
}
