/**
 * DistanceUtil.java
 */
package com.apical.ziv.q9.utils;

import com.apical.ziv.q9.shapes.Point;

/**
 * @author ziv
 *
 */
public class DistanceUtil {

	public static double distance(Point p1, Point p2) {
		if (null == p1 || null == p2) {
			return -1;
		}

		return distance((double) p1.getX(), (double) p2.getX(), (double) p1.getY(), (double) p2.getY());
	}

	public static double distance(double x1, double x2, double y1, double y2) {
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}

}
