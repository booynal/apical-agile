/**
 * Rectangle.java
 */
package com.apical.ziv.q9.shapes;

import com.apical.ziv.q9.consts.ShapeTypeConsts;
import com.apical.ziv.q9.utils.DistanceUtil;

/**
 * 长方形，x和y表示左上角的顶点
 *
 * @author ziv
 *
 */
public class Rectangle extends ClosedShape {

	private double x;
	private double y;
	private double width; // >=0
	private double height; // >=0;

	public Rectangle(double x, double y, double width, double height) {
		this(ShapeTypeConsts.RECTANGLE, x, y, width, height);

	}

	protected Rectangle(String type, double x, double y, double width, double height) {
		super(type);
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	@Override
	public String toString() {
		return String.format("shape %s: %s with top left corner at (%.2f, %.2f) and side one %.2f and side two %.2f", getId(), getType(), x, y, width, height);
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	@Override
	public boolean inside(double px, double py) {
		double x = getX();
		double y = getY();
		double x1 = x, x2 = x + getWidth();
		double y1 = y, y2 = y + getHeight();
		boolean bx = px >= x1 && px <= x2;
		boolean by = py >= y1 && py <= y2;
		return bx && by;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getX2() {
		return x + width;
	}

	public double getY2() {
		return y + height;
	}

	@Override
	public double calcArea() {
		return getWidth() * getHeight();
	}

	@Override
	public Rectangle getExternalRectangle() {
		return this;
	}

	@Override
	public boolean intersect(ClosedShape shape) {
		if (shape instanceof Rectangle) {
			return DistanceUtil.interset(this, (Rectangle) shape);
		} else if (shape instanceof Triangle) {
			Triangle tri = (Triangle) shape;
			return DistanceUtil.interset(tri, this);
		} else if (shape instanceof Donut) {
			Donut donut = (Donut) shape;
			return DistanceUtil.interset(donut, this);
		}
		return false;
	}

	@Override
	protected boolean overLap(Triangle tri) {
		if (!inside(tri.getX1(), tri.getY1())) {
			return false;
		}
		if (!inside(tri.getX2(), tri.getY2())) {
			return false;
		}
		if (!inside(tri.getX3(), tri.getY3())) {
			return false;
		}
		return true;
	}

	@Override
	protected boolean overLap(Rectangle rect) {
		double x = rect.getX();
		double y = rect.getY();
		double w = rect.getWidth();
		double h = rect.getHeight();
		if (!inside(x, y)) {
			return false;
		}
		if (!inside(x + w, y + h)) {
			return false;
		}
		return true;
	}

	@Override
	protected boolean overLap(Donut donut) {
		Rectangle externalRectangle = donut.getExternalRectangle();
		return overLap(externalRectangle);
	}

	@Override
	protected boolean overLap(Circle circle) {
		Rectangle externalRectangle = circle.getExternalRectangle();
		return overLap(externalRectangle);
	}
}
