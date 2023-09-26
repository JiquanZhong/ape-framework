package com.jiquan.user.mapper;

import com.jiquan.user.entity.po.SysUserPo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (SysUser)表数据库访问层
 *
 * @author makejava
 * @since 2023-09-25 17:56:51
 */
public interface SysUserMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysUserPo queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param sysUserPo 查询条件
     * @param pageStart  第几页
     * @param pageSize 页大小
     * @return 对象列表
     */
    List<SysUserPo> queryAllByLimit(@Param("po") SysUserPo sysUserPo, @Param("pageStart") Long pageStart, @Param("pageSize") Long pageSize);

    /**
     * 统计总行数
     *
     * @param sysUserPo 查询条件
     * @return 总行数
     */
    long count(SysUserPo sysUserPo);

    /**
     * 新增数据
     *
     * @param sysUserPo 实例对象
     * @return 影响行数
     */
    int insert(SysUserPo sysUserPo);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysUser> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<SysUserPo> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SysUser> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<SysUserPo> entities);

    /**
     * 修改数据
     *
     * @param sysUserPo 实例对象
     * @return 影响行数
     */
    int update(SysUserPo sysUserPo);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 通过主键逻辑删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int logicDeleteById(Long id);
}

