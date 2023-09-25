package com.jiquan.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.jiquan.inteceptor.SqlBeautyInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZHONG Jiquan
 * @year 2023
 */
@Configuration
public class MybatisConfiguration {

	@Bean
	@ConditionalOnProperty(name = {"sql.beauty.show"}, havingValue = "true", matchIfMissing = true)
	public SqlBeautyInterceptor sqlBeautyInterceptor(){
		return new SqlBeautyInterceptor();
	}

	@Bean
	public MybatisPlusInterceptor mybatisPlusInterceptor() {
		MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
		mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
		return mybatisPlusInterceptor;
	}
}
