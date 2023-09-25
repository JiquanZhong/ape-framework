package com.jiquan.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @author ZHONG Jiquan
 * @year 2023
 */
@Data
public class Result<T> implements Serializable {
	private Boolean success;
	private Integer code;
	private String message;
	private T data;

	public Result() {
	}

	public static Result ok(){
		return ok(null);
	}

	public static <T> Result ok(T data){
		Result<Object> result = new Result<>();
		result.setSuccess(true);
		result.setCode(ResultCode.SUCCESS);
		result.setMessage(ResultMessage.SUCCESS);
		result.setData(data);
		return result;
	}

	public static Result error(){
		return error(null);
	}

	public static <T> Result error(T Data){
		Result<Object> result = new Result<>();
		result.setSuccess(true);
		result.setCode(ResultCode.ERROR);
		result.setMessage(ResultMessage.ERROR);
		result.setData(Data);
		return result;
	}

	public static Result other(Integer resultCode, String resultMessage){
		return other(resultCode, resultMessage, null);
	}

	public static <T> Result other(Integer resultCode, String resultMessage, T data){
		Result<Object> result = new Result<>();
		result.setSuccess(true);
		result.setCode(resultCode);
		result.setMessage(resultMessage);
		result.setData(data);
		return result;
	}
}
