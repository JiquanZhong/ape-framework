package com.jiquan.user.entity.dto;

import com.jiquan.bean.PageRequest;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

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
