package com.jiquan.redis.exception;

/**
 * @author ZHONG Jiquan
 * @year 2023
 */
public class ShareLockException extends RuntimeException{
	public ShareLockException(String message) {
		super(message);
	}
}
