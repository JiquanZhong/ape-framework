package com.jiquan.user.service.impl;

import com.jiquan.bean.PageResponse;
import com.jiquan.user.convert.SysUserConverter;
import com.jiquan.user.entity.dto.SysUserDto;
import com.jiquan.user.mapper.SysUserMapper;
import com.jiquan.user.entity.po.SysUserPo;
import com.jiquan.user.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SysUser)表服务实现类
 *
 * @author makejava
 * @since 2023-09-25 17:57:05
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysUserPo queryById(Long id) {
        return this.sysUserMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @return 查询结果
     */
    @Override
    public PageResponse<SysUserPo> queryByPage(com.jiquan.user.entity.dto.SysUserDto sysUserDto) {
        SysUserPo sysUserPo = SysUserConverter.INSTANCE.convertDtoToPo(sysUserDto);
        Long pageStart = (sysUserDto.getPageIndex() - 1) * sysUserDto.getPageSize();
        long total = this.sysUserMapper.count(sysUserPo);
        List<SysUserPo> sysUserPoList = this.sysUserMapper.queryAllByLimit(sysUserPo, pageStart, sysUserDto.getPageSize());

        PageResponse<SysUserPo> pageResponse = new PageResponse<>();
        pageResponse.setCurrent(sysUserDto.getPageIndex());
        pageResponse.setPageSize(sysUserDto.getPageSize());
        pageResponse.setTotal(total);
        pageResponse.setRecords(sysUserPoList);
        return pageResponse;
    }

    /**
     * 新增数据
     *
     * @param sysUserDto 实例对象
     * @return 实例对象
     */
    @Override
    public SysUserPo insert(SysUserDto sysUserDto) {
        SysUserPo sysUserPo = SysUserConverter.INSTANCE.convertDtoToPo(sysUserDto);
        sysUserPo.insertFill();
        this.sysUserMapper.insert(sysUserPo);
        return sysUserPo;
    }

    /**
     * 修改数据
     *
     * @param sysUserDto 实例对象
     * @return 实例对象
     */
    @Override
    public SysUserPo update(SysUserDto sysUserDto) {
        SysUserPo sysUserPo = SysUserConverter.INSTANCE.convertDtoToPo(sysUserDto);
        sysUserPo.updateFill();
        this.sysUserMapper.update(sysUserPo);
        return this.queryById(sysUserPo.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.sysUserMapper.deleteById(id) > 0;
    }

    /**
     * 通过主键逻辑删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean logicDeleteById(Long id) {
        return this.sysUserMapper.logicDeleteById(id) > 0;
    }
}
