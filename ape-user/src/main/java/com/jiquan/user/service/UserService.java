package com.jiquan.user.service;

import com.jiquan.user.entity.dto.UserDto;
import org.springframework.stereotype.Service;

/**
 * @author ZHONG Jiquan
 * @year 2023
 */
public interface UserService {
	int addUser(UserDto userDto);

}
