package com.jiquan.common;

import com.jiquan.bean.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author ZHONG Jiquan
 * @year 2023
 */
@RestControllerAdvice
@Slf4j
public class ExceptionAdapterController {

	@ExceptionHandler(RuntimeException.class)
	public Result runtimeExceptionHandler(RuntimeException runtimeException){
//		log.error("捕获到RuntimeException");
		return Result.error(runtimeException.getMessage());
	}

	@ExceptionHandler(BindException.class)
	public Result bindExceptionHandler(BindException bindException){
//		log.error("捕获到BindException");
		return Result.error(bindException.getMessage());
	}

	@ExceptionHandler(Exception.class)
	public Result otherExceptionHandler(Exception exception){
		return Result.error(exception.getMessage());
	}
}
