package com.jiquan.user.controller;

import com.jiquan.bean.PageResponse;
import com.jiquan.bean.Result;
import com.jiquan.user.entity.po.SysUser;
import com.jiquan.user.entity.req.SysUserReq;
import com.jiquan.user.service.SysUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (SysUser)表控制层
 *
 * @author makejava
 * @since 2023-09-25 17:56:51
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {
    /**
     * 服务对象
     */
    @Resource
    private SysUserService sysUserService;

    /**
     * 分页查询
     *
     * @return 查询结果
     */
    @GetMapping
    public Result<PageResponse<SysUser>> queryByPage(SysUserReq sysUserReq) {
        return Result.ok(this.sysUserService.queryByPage(sysUserReq));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/{id}")
    public Result<SysUser> queryById(@PathVariable("id") Long id) {
        return Result.ok(this.sysUserService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param sysUser 实体
     * @return 新增结果
     */
    @PostMapping
    public Result<SysUser> add(@RequestBody SysUser sysUser) {
        return Result.ok(this.sysUserService.insert(sysUser));
    }

    /**
     * 编辑数据
     *
     * @param sysUser 实体
     * @return 编辑结果
     */
    @PutMapping("/update")
    public Result<SysUser> edit(@RequestBody SysUser sysUser) {
        return Result.ok(this.sysUserService.update(sysUser));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/{id}")
    public Result<Boolean> deleteById(@PathVariable Long id) {
        return Result.ok(this.sysUserService.deleteById(id));
    }
}

