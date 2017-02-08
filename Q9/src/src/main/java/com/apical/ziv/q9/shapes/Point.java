/**
 * Point.java
 */
package com.apical.ziv.q9.shapes;

import java.util.concurrent.atomic.AtomicLong;

import com.apical.ziv.q9.consts.ShapeTypeConsts;
import com.apical.ziv.q9.interfaces.Shape;

/**
 * 点
 *
 * @author ziv
 *
 */
public class Point implements Shape {

	private static AtomicLong idGenerator = new AtomicLong();

	private long id;
	private double x;
	private double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
		id = idGenerator.incrementAndGet();
	}

	@Override
	public String toString() {
		return String.format("%s at (%.2f, %.2f)", getType(), x, y);
	}

	@Override
	public String getType() {
		return ShapeTypeConsts.POINT;
	}

	@Override
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

}
