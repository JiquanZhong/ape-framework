package com.jiquan.user.controller;

import com.jiquan.bean.Result;
import com.jiquan.user.entity.dto.UserDto;
import com.jiquan.user.entity.req.UserListReq;
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
	public Result addUser(@RequestBody UserReq userReq){
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userReq, userDto);
		return Result.ok(userService.addUser(userDto));
	}

	@DeleteMapping("/{id}")
	public Result deleteUser(@PathVariable Integer id){
		return Result.ok(userService.delete(id));
	}

	@GetMapping
	public Result getUserPage(@RequestBody UserListReq userListReq){
		UserDto userDto = new UserDto();
		System.out.println(userListReq.toString());
		BeanUtils.copyProperties(userListReq, userDto);
		return Result.ok(userService.getUserPage(userDto));
	}
}
