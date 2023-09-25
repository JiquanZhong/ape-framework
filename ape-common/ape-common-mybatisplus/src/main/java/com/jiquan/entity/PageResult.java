package com.jiquan.entity;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author ZHONG Jiquan
 * @year 2023
 */
@Data
public class PageResult<T> implements Serializable {
	private Long total;

	private Long size;

	private Long current;

	private Long pages;

	private List<T> records;

	public void loadData(IPage<T> pageData){
		this.setTotal(pageData.getTotal());
		this.setSize(pageData.getSize());
		this.setCurrent(pageData.getCurrent());
		this.setPages(pageData.getPages());
		this.setRecords(pageData.getRecords());
	}
}
