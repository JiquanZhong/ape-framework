package com.jiquan.bean;

import lombok.Data;
import lombok.Setter;

/**
 * @author ZHONG Jiquan
 * @year 2023
 */
@Data
public class PageRequest {
	private Long pageNo = 1L;

	private Long pageSize = 10L;

	public Long getPageNo(){
		if(pageNo == null || pageSize < 1){
			return 1L;
		}
		return pageNo;
	}

	public Long getPageSize(){
		if(pageSize == null || pageSize < 1 || pageSize > Integer.MAX_VALUE){
			return 10L;
		}
		return pageSize;
	}
}
