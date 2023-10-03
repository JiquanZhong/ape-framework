package com.jiquan.user.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiquan.entity.PageResult;
import com.jiquan.user.entity.dto.UserDto;
import com.jiquan.user.entity.po.UserPo;
import com.jiquan.user.mapper.UserMapper;
import com.jiquan.user.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.annotations.Cacheable;

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
		UserPo userPO = new UserPo();
		BeanUtils.copyProperties(userDto, userPO);
		int count = userMapper.insert(userPO);
		return count;
	}

	@Override
	public int delete(Integer id) {
		return userMapper.deleteById(id);
	}


	@Override
	public PageResult<UserPo> getUserPage(UserDto userDto) {
		IPage<UserPo> userPoPage = new Page<>(userDto.getPageIndex(), userDto.getPageSize());
		IPage<UserPo> userPage = userMapper.getUserPage(userPoPage);
		PageResult<UserPo> pageResult = new PageResult<>();
		pageResult.loadData(userPage);
		return pageResult;
	}
}
