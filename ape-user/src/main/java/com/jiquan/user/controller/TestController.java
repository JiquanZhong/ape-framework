package com.jiquan.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZHONG Jiquan
 * @year 2023
 */
@RestController("/")
public class TestController {

	@GetMapping("/test")
	public String test(){
		return "Hello World!";
	}

}
