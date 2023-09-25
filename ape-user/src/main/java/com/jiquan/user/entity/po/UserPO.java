package com.jiquan.user.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import com.jiquan.entity.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * @author ZHONG Jiquan
 * @year 2023
 */

@TableName("user")
@Data
public class UserPO extends BaseEntity {

	@TableId(value = "id", type = IdType.AUTO)
	private Long id;

	private String name;

	private Integer age;

}
