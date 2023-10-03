package com.jiquan.user.controller;

import com.jiquan.bean.PageResponse;
import com.jiquan.bean.Result;
import com.jiquan.user.convert.SysUserConverter;
import com.jiquan.user.entity.dto.SysUserDto;
import com.jiquan.user.entity.po.SysUserPo;
import com.jiquan.user.entity.req.SysUserReq;
import com.jiquan.user.service.SysUserService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
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
    @GetMapping("/getPage")
    public Result<PageResponse<SysUserPo>> queryByPage(@RequestBody SysUserReq sysUserReq) {
        SysUserDto sysUserDto = SysUserConverter.INSTANCE.convertReqToDto(sysUserReq);
        return Result.ok(this.sysUserService.queryByPage(sysUserDto));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/get/{id}")
    @Cacheable(cacheNames = "SysUser", key = "'querySysUserById'+#id")
    public Result<SysUserPo> queryById(@PathVariable("id") Long id) {
        return Result.ok(this.sysUserService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param sysUserReq 实体
     * @return 新增结果
     */
    @PostMapping("/add")
    public Result<SysUserPo> add(@RequestBody SysUserReq sysUserReq) {
        SysUserDto sysUserDto = SysUserConverter.INSTANCE.convertReqToDto(sysUserReq);
        return Result.ok(this.sysUserService.insert(sysUserDto));
    }

    /**
     * 编辑数据
     *
     * @param sysUserReq 实体
     * @return 编辑结果
     */
    @PutMapping("/update")
    @CacheEvict(cacheNames = "SysUser", key = "'querySysUserById'+#id")
    public Result<SysUserPo> edit(@RequestBody SysUserReq sysUserReq) {
        SysUserDto sysUserDto = SysUserConverter.INSTANCE.convertReqToDto(sysUserReq);
        return Result.ok(this.sysUserService.update(sysUserDto));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("/delete/{id}")
    public Result<Boolean> deleteById(@PathVariable Long id) {
        return Result.ok(this.sysUserService.logicDeleteById(id));
    }
}

