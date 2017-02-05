/**
 * ShapeException.java
 */
package com.apical.ziv.q9.exceptions;

/**
 * @author ziv
 *
 */
public class ShapeException extends Exception {

	private static final long serialVersionUID = -7879017199040872187L;

	public ShapeException() {
		super();
	}

	public ShapeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ShapeException(String message, Throwable cause) {
		super(message, cause);
	}

	public ShapeException(String message) {
		super(message);
	}

	public ShapeException(Throwable cause) {
		super(cause);
	}

}
