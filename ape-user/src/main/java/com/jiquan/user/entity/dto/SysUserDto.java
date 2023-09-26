package com.jiquan.user.entity.dto;

import com.jiquan.bean.PageRequest;
import lombok.Data;

import java.io.Serializable;

/**
 * @author ZHONG Jiquan
 * @year 2023
 */
@Data
public class SysUserDto extends PageRequest implements Serializable {

	private String name;

	private Integer age;

}
