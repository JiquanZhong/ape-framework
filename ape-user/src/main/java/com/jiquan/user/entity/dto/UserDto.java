package com.jiquan.user.entity.dto;

import lombok.Data;


/**
 * @author ZHONG Jiquan
 * @year 2023
 */
@Data
public class UserDto {
	private Long id;

	private String name;

	private Integer age;

	private Integer pageIndex;

	private Integer pageSize;
}
