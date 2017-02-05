/**
 * Creator.java
 */
package com.apical.ziv.q9.interfaces;

import java.util.Comparator;

import com.apical.ziv.q9.exceptions.ShapeCreateException;

/**
 * @author ziv
 *
 */
public interface Creatable<T> {

	boolean isSupport(String input);

	T create(String input) throws ShapeCreateException;

	int index();

	CreatorComparator comparator = new CreatorComparator();

	/**
	 * @author ziv
	 *
	 */
	public static class CreatorComparator implements Comparator<Creatable<?>> {

		@Override
		public int compare(Creatable<?> o1, Creatable<?> o2) {
			if (null == o1) {
				return -1;
			} else if (null == o2) {
				return 1;
			} else {
				return o1.index() - o2.index();
			}
		}
	}

}
