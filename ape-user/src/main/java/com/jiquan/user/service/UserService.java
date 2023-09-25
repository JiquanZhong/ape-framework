package com.jiquan.user.service;

import com.jiquan.entity.PageResult;
import com.jiquan.user.entity.dto.UserDto;
import com.jiquan.user.entity.po.UserPo;

/**
 * @author ZHONG Jiquan
 * @year 2023
 */
public interface UserService {
	int addUser(UserDto userDto);

	int delete(Integer id);

	PageResult<UserPo> getUserPage(UserDto userPageDto);

}
