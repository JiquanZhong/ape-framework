package com.jiquan.user.controller;

import com.jiquan.user.entity.dto.UserDto;
import com.jiquan.user.entity.req.UserReq;
import com.jiquan.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ZHONG Jiquan
 * @year 2023
 */
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping
	public int addUser(@RequestBody UserReq userReq){
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userReq, userDto);
		int i = userService.addUser(userDto);
		return i;
	}

}
