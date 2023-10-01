package com.jiquan.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author ZHONG Jiquan
 * @year 2023
 */
@SpringBootApplication
@MapperScan(value = "com.jiquan.*.mapper")
@ComponentScan("com.jiquan")
public class UserApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class);
	}
}
