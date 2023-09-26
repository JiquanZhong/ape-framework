package com.jiquan.user.service;

import com.jiquan.bean.PageResponse;
import com.jiquan.user.entity.dto.SysUserDto;
import com.jiquan.user.entity.po.SysUserPo;

/**
 * (SysUser)表服务接口
 *
 * @author makejava
 * @since 2023-09-25 17:57:05
 */
public interface SysUserService {

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 */
	SysUserPo queryById(Long id);

	/**
	 * 分页查询
	 *
	 * @param sysUserDto 筛选条件
	 * @return 查询结果
	 */
	PageResponse<SysUserPo> queryByPage(SysUserDto sysUserDto);

	/**
	 * 新增数据
	 *
	 * @param sysUserPo 实例对象
	 * @return 实例对象
	 */
	SysUserPo insert(SysUserDto sysUserPo);

	/**
	 * 修改数据
	 *
	 * @param sysUserPo 实例对象
	 * @return 实例对象
	 */
	SysUserPo update(SysUserDto sysUserPo);

	/**
	 * 通过主键删除数据
	 *
	 * @param id 主键
	 * @return 是否成功
	 */
	boolean deleteById(Long id);

	/**
	 * 逻辑删除
	 * @param id 主键
	 * @return
	 */
	boolean logicDeleteById(Long id);
}
