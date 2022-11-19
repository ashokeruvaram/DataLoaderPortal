package com.dataload.utils;

public class LoadExceptionHandler extends Exception {

	static final long serialVersionUID = -3387516993124229948L;

	public LoadExceptionHandler() {
	}

	public LoadExceptionHandler(String message, Throwable cause) {
		super(message, cause);
	}

	public LoadExceptionHandler(String message) {
		super(message);
	}

	public LoadExceptionHandler(Throwable cause) {
		super(cause);
	}

	public LoadExceptionHandler(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
