/**
 * ShapeCreateException.java
 */
package com.apical.ziv.q9.exceptions;

/**
 * @author ziv
 *
 */
public class ShapeCreateException extends ShapeException {

	private static final long serialVersionUID = -5876609655367814837L;

	public ShapeCreateException() {
		super();
	}

	public ShapeCreateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ShapeCreateException(String message, Throwable cause) {
		super(message, cause);
	}

	public ShapeCreateException(String message) {
		super(message);
	}

	public ShapeCreateException(Throwable cause) {
		super(cause);
	}

}
