package com.jiquan.user.convert;

import com.jiquan.user.entity.dto.SysUserDto;
import com.jiquan.user.entity.po.SysUserPo;
import com.jiquan.user.entity.req.SysUserReq;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author ZHONG Jiquan
 * @year 2023
 */
@Mapper
public interface SysUserConverter {

	SysUserConverter INSTANCE = Mappers.getMapper(SysUserConverter.class);

	SysUserPo convertDtoToPo(SysUserDto sysUserDto);

	SysUserPo convertReqToPo(SysUserReq sysUserReq);

	SysUserDto convertReqToDto(SysUserReq sysUserReq);
}
