/**
 * Donut.java
 */
package com.apical.ziv.q9.shapes;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import com.apical.ziv.q9.consts.ShapeTypeConsts;
import com.apical.ziv.q9.utils.DistanceUtil;

/**
 * 圆环，从圆继承，圆的半径为圆环的外径
 *
 * @author ziv
 *
 */
public class Donut extends ClosedShape {

	private double x;
	private double y;
	private double innerRadius;
	private double outterRadius;

	public Donut(double x, double y, double innerRadius, double outterRadius) {
		this(ShapeTypeConsts.DONUT, x, y, innerRadius, outterRadius);
	}

	protected Donut(String type, double x, double y, double innerRadius, double outterRadius) {
		super(type);
		this.x = x;
		this.y = y;
		this.innerRadius = innerRadius;
		this.outterRadius = outterRadius;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getInnerRadius() {
		return innerRadius;
	}

	public double getOutterRadius() {
		return outterRadius;
	}

	public void setOutterRadius(double outterRadius) {
		this.outterRadius = outterRadius;
	}

	@Override
	public String toString() {
		return String.format("shape %s: %s with centre at (%.2f, %.2f) and innerRadius %.2f and outterRadius %.2f", getId(), getType(), x, y, getInnerRadius(), getOutterRadius());
	}

	@Override
	public boolean inside(double px, double py) {
		double distance = DistanceUtil.distance(x, px, y, py);
		if (distance > outterRadius) {
			return false;
		} else {
			if (innerRadius <= 0.0001) { // Circle
				return true;
			} else {
				if (distance > innerRadius) {
					return true;
				} else {
					return false;
				}
			}
		}
	}

	@Override
	public double calcArea() {
		return (double) (Math.PI * Math.pow(getOutterRadius(), 2) - Math.PI * Math.pow(getInnerRadius(), 2));
	}

	@Override
	public Rectangle getExternalRectangle() {
		double rx = x - outterRadius;
		double ry = y - outterRadius;
		double sideLength = 2 * outterRadius;
		return new Rectangle(rx, ry, sideLength, sideLength);
	}

	@Override
	public boolean intersect(ClosedShape shape) {
		if (shape instanceof Donut) {
			Donut that = (Donut) shape;
			double dis = DistanceUtil.distance(x, that.x, y, that.y);
			if (dis > outterRadius + that.outterRadius) {
				return false;
			}
			if (this.innerRadius > that.outterRadius && this.innerRadius - that.outterRadius > dis) {
				return false;
			}
			if (that.innerRadius > this.outterRadius && that.innerRadius - this.outterRadius > dis) {
				return false;
			}
			return true;
		}
		return false;

	}

	protected boolean overLap(Triangle tri) {
		// if overlap triangle, the heart of donut must be out of triangle
		if (tri.inside(x, y))
			return false;

		// if the point of triangle is not in Donut return false
		if (!inside(tri.getX1(), tri.getY1()))
			return false;
		if (!inside(tri.getX2(), tri.getY2()))
			return false;
		if (!inside(tri.getX3(), tri.getY3()))
			return false;
		// if the distance from line to heart is less than inner radius return
		// false
		if (Line2D.ptSegDist(tri.getX1(), tri.getY1(), tri.getX2(), tri.getY2(), x, y) < innerRadius)
			return false;
		if (Line2D.ptSegDist(tri.getX2(), tri.getY2(), tri.getX3(), tri.getY3(), x, y) < innerRadius)
			return false;
		if (Line2D.ptSegDist(tri.getX3(), tri.getY3(), tri.getX1(), tri.getY1(), x, y) < innerRadius)
			return false;
		return true;
	}

	protected boolean overLap(Rectangle rect) {
		if (rect.inside(x, y))
			return false;

		double x = rect.getX();
		double y = rect.getY();
		double w = rect.getWidth();
		double h = rect.getHeight();
		if (!inside(x, y))
			return false;
		if (!inside(x + w, y))
			return false;
		if (!inside(x + w, y + h))
			return false;
		if (!inside(x, y + h))
			return false;

		// if the distance from line to heart is less than inner radius return
		// false
		if (Line2D.ptSegDist(x, y, x + w, y, this.x, this.y) < innerRadius)
			return false;
		if (Line2D.ptSegDist(x + w, y, x + w, y + h, this.x, this.y) < innerRadius)
			return false;
		if (Line2D.ptSegDist(x + w, y + h, x, y + h, this.x, this.y) < innerRadius)
			return false;
		if (Line2D.ptSegDist(x, y + h, x, y, this.x, this.y) < innerRadius)
			return false;

		return true;

	}

	protected boolean overLap(Donut donut) {
		Circle big1Circle = new Circle(x, y, outterRadius);
		Circle big2Circle = new Circle(donut.x, donut.y, donut.outterRadius);
		if (!big1Circle.overLap(big2Circle))
			return false;
		double distance = DistanceUtil.distance(x, donut.x, y, donut.y);
		if (distance >= innerRadius + donut.innerRadius) {
			return true;
		}
		if (donut.innerRadius >= distance + innerRadius) {
			return true;
		}
		return false;
	}

	@Override
	protected boolean overLap(Circle circle) {
		double dis = Point2D.distance(x, y, circle.getX(), circle.getY());
		double min = dis - circle.getRadius();
		double max = dis + circle.getRadius();
		if (min > innerRadius && max <= outterRadius)
			return true;
		return false;
	}

}
