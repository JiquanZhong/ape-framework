package com.jiquan.entity;

/**
 * @author ZHONG Jiquan
 * @year 2023
 */
public enum DeleteFlag {
	/**
	 * 显示状态
	 */
	NORAML(0),
	/**
	 * 删除状态
	 */
	DELETED(1);

	private Integer deleteFlag;

	private DeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Integer getValue() {
		return this.deleteFlag;
	}
}
