package com.jiquan.user.service.impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.jiquan.user.entity.dto.UserDto;
import com.jiquan.user.entity.po.UserPO;
import com.jiquan.user.mapper.UserMapper;
import com.jiquan.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ZHONG Jiquan
 * @year 2023
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public int addUser(UserDto userDto) {
		UserPO userPO = new UserPO();
		BeanUtils.copyProperties(userDto, userPO);
		int count = userMapper.insert(userPO);
		return count;
	}

	@Override
	public int delete(Integer id) {
		return userMapper.deleteById(id);
	}
}
