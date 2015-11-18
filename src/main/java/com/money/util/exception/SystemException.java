package com.money.util.exception;

/**
 * Created by jennifert on 2015/11/17.
 */
public class SystemException extends RuntimeException {

	public SystemException(Throwable cause) {
		super(cause);
	}

	public SystemException(String message, Throwable cause) {
		super(message, cause);
	}

	public SystemException(String message) {
		super(message);
	}

	public SystemException() {
		super();
	}
}
