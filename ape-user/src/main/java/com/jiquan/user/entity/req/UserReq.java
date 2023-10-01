package com.jiquan.user.entity.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author ZHONG Jiquan
 * @year 2023
 */

@Data
@ApiModel("用户请求")
public class UserReq {

	private String name;

	@ApiModelProperty(value = "姓名")
	private Long id;

	@ApiModelProperty(value = "年龄")
	private Integer age;
}
