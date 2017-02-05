/**
 * Rectangle.java
 */
package com.apical.ziv.q9.shapes;

import com.apical.ziv.q9.consts.ShapeTypeConsts;

/**
 * 长方形，从正方形继承而来
 *
 * @author ziv
 *
 */
public class Rectangle extends Square {

	private float height;

	public Rectangle(float x, float y, float width, float height) {
		super(ShapeTypeConsts.RECTANGLE, x, y, width);
		this.height = height;
	}

	@Override
	public String toString() {
		return String.format("shape %s: %s with top left corner at (%.2f, %.2f) and side one %.2f and side two %.2f", getIdLong(), getType(), getX(), getY(), getSideLength(), getHeight());
	}

	public float getWidth() {
		return super.getSideLength();
	}

	public void setWidth(float width) {
		super.setSideLength(width);
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	/**
	 * 获取宽度
	 */
	@Override
	@Deprecated
	public float getSideLength() {
		return getWidth();
	}

	/**
	 * 设置宽度
	 */
	@Override
	@Deprecated
	public void setSideLength(float width) {
		setWidth(width);
	}

	@Override
	public boolean inside(Point point) {
		float x = getX();
		float y = getY();
		float px = point.getX();
		float py = point.getY();
		float x1 = x, x2 = x + getWidth();
		float y1 = y, y2 = y - getHeight();
		boolean bx = px >= x1 && px <= x2;
		boolean by = py <= y1 && py >= y2;
		return bx && by;
	}

	@Override
	public float calcArea() {
		return getWidth() * getHeight();
	}

	@Override
	public Rectangle getExternalRectangle() {
		return this;
	}

}
