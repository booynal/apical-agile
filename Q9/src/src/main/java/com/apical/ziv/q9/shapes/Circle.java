/**
 * Circle.java
 */
package com.apical.ziv.q9.shapes;

import com.apical.ziv.q9.consts.ShapeTypeConsts;
import com.apical.ziv.q9.utils.DistanceUtil;

/**
 * 圆形
 *
 * @author ziv
 *
 */
public class Circle extends ClosedShape {

	private float x;
	private float y;
	private float radius;

	public Circle(float x, float y, float radius) {
		super(ShapeTypeConsts.CIRCLE);
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	protected Circle(String name, float x, float y, float radius) {
		super(name);
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	@Override
	public String toString() {
		return String.format("shape %s: %s with centre at (%.2f, %.2f) and radius %.2f", getId(), getType(), x, y, radius);
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}

	@Override
	public boolean inside(Point point) {
		return DistanceUtil.distance(x, point.getX(), y, point.getY()) <= radius;
	}

	@Override
	public float calcArea() {
		return (float) (Math.PI * Math.pow(radius, 2));
	}

	@Override
	public Rectangle getExternalRectangle() {
		float rx = x - radius;
		float ry = y + radius;
		float sideLength = 2 * radius;
		return new Rectangle(rx, ry, sideLength, sideLength);
	}

}
