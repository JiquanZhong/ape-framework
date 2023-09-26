package com.jiquan.bean;

import lombok.Data;

/**
 * @author ZHONG Jiquan
 * @year 2023
 */
@Data
public class PageRequest {
	private Long pageIndex = 1L;

	private Long pageSize = 10L;

	public Long getPageIndex(){
		if(pageIndex == null || pageSize < 1){
			return 1L;
		}
		return pageIndex;
	}

	public Long getPageSize(){
		if(pageSize == null || pageSize < 1 || pageSize > Integer.MAX_VALUE){
			return 10L;
		}
		return pageSize;
	}
}
