/**
 * NotImplementedException.java
 */
package com.apical.ziv.q9.exceptions;

/**
 * @author ziv
 *
 */
public class NotImplementedException extends RuntimeException {

	private static final long serialVersionUID = -3593379673648099579L;

	public NotImplementedException() {
		super();
	}

	public NotImplementedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public NotImplementedException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotImplementedException(String message) {
		super(message);
	}

	public NotImplementedException(Throwable cause) {
		super(cause);
	}

}
