/**
 * Triangle.java
 */
package com.apical.ziv.q9.shapes;

import java.awt.geom.Line2D;

import com.apical.ziv.q9.consts.ShapeTypeConsts;
import com.apical.ziv.q9.utils.DistanceUtil;

/**
 * 三角形
 *
 * @author ziv
 *
 */
public class Triangle extends ClosedShape {

	private double x1;
	private double y1;
	private double x2;
	private double y2;
	private double x3;
	private double y3;

	public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
		super(ShapeTypeConsts.TRIANGLE);
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;
	}

	@Override
	public String toString() {
		return String.format("shape %s: %s with point ont at (%.2f, %.2f) and point two at (%.2f, %.2f) and point three at (%.2f, %.2f)", getId(), getType(), x1, y1, x2, y2, x3, y3);
	}

	public double getX1() {
		return x1;
	}

	public void setX1(double x1) {
		this.x1 = x1;
	}

	public double getY1() {
		return y1;
	}

	public void setY1(double y1) {
		this.y1 = y1;
	}

	public double getX2() {
		return x2;
	}

	public void setX2(double x2) {
		this.x2 = x2;
	}

	public double getY2() {
		return y2;
	}

	public void setY2(double y2) {
		this.y2 = y2;
	}

	public double getX3() {
		return x3;
	}

	public void setX3(double x3) {
		this.x3 = x3;
	}

	public double getY3() {
		return y3;
	}

	public void setY3(double y3) {
		this.y3 = y3;
	}

	@Override
	public boolean inside(double x, double y) {
		double mx1 = x - x1;
		double my1 = y - y1;

		double mx2 = x - x2;
		double my2 = y - y2;

		double mx3 = x - x3;
		double my3 = y - y3;

		double a = mx1 * my2 - my1 * mx2;
		double b = mx2 * my3 - my2 * mx3;
		double c = mx3 * my1 - my3 * mx1;
		return a <= 0 && b <= 0 && c <= 0 || a > 0 && b > 0 && c > 0;
	}

	/**
	 * 已知三边求面积（海伦公式）<br/>
	 * S=√[p(p-a)(p-b)(p-c)] <br/>
	 * p为半周长： p=(a+b+c)/2
	 */
	@Override
	public double calcArea() {
		double a = DistanceUtil.distance(x1, x2, y1, y2);
		double b = DistanceUtil.distance(x1, x3, y1, y3);
		double c = DistanceUtil.distance(x2, x3, y2, y3);
		double p = (a + b + c) / 2;
		double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
		return (double) s;
	}

	@Override
	public Rectangle getExternalRectangle() {
		double minx = Math.min(x1, Math.min(x2, x3));
		double miny = Math.min(y1, Math.min(y2, y3));
		double maxx = Math.max(x1, Math.max(x2, x3));
		double maxy = Math.max(y1, Math.max(y2, y3));
		return new Rectangle(minx, miny, maxx - minx, maxy - miny);

	}

	@Override
	public boolean intersect(ClosedShape shape) {
		// TODO Auto-generated method stub
		return false;
	}

	protected boolean overLap(Triangle tri) {
		if (!inside(tri.getX1(), tri.getY1()))
			return false;
		if (!inside(tri.getX2(), tri.getY2()))
			return false;
		if (!inside(tri.getX2(), tri.getY3()))
			return false;
		return true;
	}

	protected boolean overLap(Rectangle rect) {
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
		return true;
	};

	protected boolean overLap(Donut donut) {
		double x = donut.getX();
		double y = donut.getY();
		if (!inside(x, y))
			return false;
		double radius = donut.getOutterRadius();

		if (Line2D.ptSegDist(x1, y1, x2, y2, x, y) < radius)
			return false;
		if (Line2D.ptSegDist(x2, y2, x3, y3, x, y) < radius)
			return false;
		if (Line2D.ptSegDist(x3, y3, x1, y1, x, y) < radius)
			return false;
		return true;
	}

	@Override
	protected boolean overLap(Circle circle) {
		double x = circle.getX();
		double y = circle.getY();
		double r = circle.getRadius();
		if (!inside(x, y))
			return false;
		if (Line2D.ptSegDist(x1, y1, x2, y2, x, y) < r)
			return false;
		if (Line2D.ptSegDist(x2, y2, x3, y3, x, y) < r)
			return false;
		if (Line2D.ptSegDist(x3, y3, x1, y1, x, y) < r)
			return false;
		return true;
	}

}
