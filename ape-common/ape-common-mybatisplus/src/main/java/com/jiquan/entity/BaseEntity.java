package com.jiquan.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ZHONG Jiquan
 * @year 2023
 */
@Data
public class BaseEntity implements Serializable {
	@TableField(fill = FieldFill.INSERT)
	private String createBy;

	@TableField(fill = FieldFill.INSERT)
	private Date createTime;

	@TableField(fill = FieldFill.UPDATE)
	private String updateBy;

	@TableField(fill = FieldFill.UPDATE)
	private Date updateTime;

	@TableField(fill = FieldFill.INSERT)
	@TableLogic
	private Integer deleteFlag;

	@TableField(fill = FieldFill.INSERT)
	private Integer version;

	public void setVersion(Integer version) {
		this.version = version;
	}

	public void insertFill() {
		this.createBy = "jiquan";
		this.createTime = new Date();
		this.deleteFlag = DeleteFlag.NORAML.getValue();
		this.version = 0;
	}

	public void updateFill() {
		this.updateBy = "jiquan";
		this.updateTime = new Date();
	}
}
