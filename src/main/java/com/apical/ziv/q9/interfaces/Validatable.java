/**
 * Validatable.java
 */
package com.apical.ziv.q9.interfaces;

import com.apical.ziv.q9.exceptions.ValidateException;

/**
 * @author ziv
 *
 */
public interface Validatable {

	void validate(String[] words) throws ValidateException;

}
