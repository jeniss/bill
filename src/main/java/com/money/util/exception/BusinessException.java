package com.money.util.exception;

/**
 * Created by jennifert on 2015/11/17.
 */
public class BusinessException extends RuntimeException {
	public BusinessException() {
		super();
	}

	public BusinessException(Throwable cause) {
		super(cause);
	}

	public BusinessException(String message) {
		super(message);
	}

	public BusinessException(String message, Throwable cause) {
		super(message, cause);
	}
}
