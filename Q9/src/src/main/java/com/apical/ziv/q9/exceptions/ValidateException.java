/**
 * ValidateException.java
 */
package com.apical.ziv.q9.exceptions;

/**
 * @author ziv
 *
 */
public class ValidateException extends ShapeException {

	private static final long serialVersionUID = 7709246334211359190L;

	public ValidateException() {
		super();
	}

	public ValidateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ValidateException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValidateException(String message) {
		super(message);
	}

	public ValidateException(Throwable cause) {
		super(cause);
	}

}
