/**
 * Circle.java
 */
package com.apical.ziv.q9.shapes;

import java.awt.geom.Point2D;

import com.apical.ziv.q9.consts.ShapeTypeConsts;
import com.apical.ziv.q9.utils.DistanceUtil;

/**
 * 圆形
 *
 * @author ziv
 *
 */
public class Circle extends ClosedShape {

	double x;
	double y;
	double radius;

	public Circle(double x, double y, double radius) {
		super(ShapeTypeConsts.CIRCLE);
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	@Override
	public String toString() {
		return String.format("shape %s: %s with centre at (%.2f, %.2f) and radius %.2f", getId(), getType(), getX(), getY(), getRadius());
	}

	public double getRadius() {
		return radius;
	}

	public boolean intersect(Circle thatCircle) {

		double distance = DistanceUtil.distance(getX(), thatCircle.getX(), getY(), thatCircle.getY());
		if (Math.abs(getRadius() - thatCircle.getRadius()) <= distance && distance <= getRadius() + thatCircle.getRadius()) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean intersect(ClosedShape shape) {
		double radius = getRadius();
		double x = getX();
		double y = getY();
		if (shape instanceof Rectangle) {
			Rectangle rect = (Rectangle) shape;
			double rx = rect.getX();
			double ry = rect.getY();
			double width = rect.getWidth();
			double height = rect.getHeight();
			if (DistanceUtil.distance(x, y, rx, ry) < radius) {
				return true;
			}
			if (DistanceUtil.distance(x, y, rx + width, ry) < radius) {
				return true;
			}
			if (DistanceUtil.distance(x, y, rx, ry + height) < radius) {
				return true;
			}
			if (DistanceUtil.distance(x, y, rx + width, ry + height) < radius) {
				return true;
			}
			return false;
		} else if (shape instanceof Circle) {
			Circle thatCircle = (Circle) shape;
			double distance = DistanceUtil.distance(getX(), thatCircle.getX(), getY(), thatCircle.getY());
			if (distance < getRadius() + thatCircle.getRadius()) {
				return true;
			} else {
				return false;
			}
		}
		if (shape instanceof Triangle) {
			Triangle tri = (Triangle) shape;
		} else {

		}
		return false;
	}

	@Override
	protected boolean overLap(Triangle tri) {
		double x = getX();
		double y = getY();
		double radius = getRadius();
		if (DistanceUtil.distance(x, tri.getX1(), y, tri.getY1()) > radius) {
			return false;
		}
		if (DistanceUtil.distance(x, tri.getX2(), y, tri.getY2()) > radius) {
			return false;
		}
		if (DistanceUtil.distance(x, tri.getX3(), y, tri.getY3()) > radius) {
			return false;
		}
		return true;
	}

	@Override
	protected boolean overLap(Donut donut) {

		double x2 = donut.getX();
		double y2 = donut.getY();
		double dis = DistanceUtil.distance(x, x2, y, y2);
		if (radius >= dis + donut.getOutterRadius()) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean inside(double x, double y) {
		double distance = DistanceUtil.distance(x, this.x, y, this.y);
		if (distance > radius) {
			return false;
		} else {
			return true;
		}
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
		if (!inside(x + w, y)) {
			return false;
		}
		if (!inside(x + w, y + h)) {
			return false;
		}
		if (!inside(x, y + h)) {
			return false;
		}
		return true;
	}

	@Override
	protected boolean overLap(Circle circle) {
		double dis = Point2D.distance(x, y, circle.getX(), circle.getY());
		if (radius >= dis + circle.getRadius()) {
			return true;
		}
		return false;
	}

	@Override
	public double calcArea() {
		return Math.PI * Math.pow(radius, 2);
	}

	@Override
	public Rectangle getExternalRectangle() {
		double rx = x - radius;
		double ry = y - radius;
		double sideLength = 2 * radius;
		return new Rectangle(rx, ry, sideLength, sideLength);
	}
}
