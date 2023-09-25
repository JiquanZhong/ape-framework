package com.jiquan.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jiquan.user.entity.po.UserPo;
import org.springframework.stereotype.Repository;

/**
 * @author ZHONG Jiquan
 * @year 2023
 */
@Repository
public interface UserMapper extends BaseMapper<UserPo> {

	IPage<UserPo> getUserPage(IPage<UserPo>  userPoPage);

}
