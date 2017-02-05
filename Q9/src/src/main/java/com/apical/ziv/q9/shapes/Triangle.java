/**
 * Triangle.java
 */
package com.apical.ziv.q9.shapes;

import com.apical.ziv.q9.consts.ShapeTypeConsts;
import com.apical.ziv.q9.utils.DistanceUtil;

/**
 * 三角形
 *
 * @author ziv
 *
 */
public class Triangle extends ClosedShape {

	private float x1;
	private float y1;
	private float x2;
	private float y2;
	private float x3;
	private float y3;

	public Triangle(float x1, float y1, float x2, float y2, float x3, float y3) {
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
		return String.format("shape %s: %s with point ont at (%.2f, %.2f) and point two at (%.2f, %.2f) and point three at (%.2f, %.2f)", getIdLong(), getType(), x1, y1, x2, y2, x3, y3);
	}

	public float getX1() {
		return x1;
	}

	public void setX1(float x1) {
		this.x1 = x1;
	}

	public float getY1() {
		return y1;
	}

	public void setY1(float y1) {
		this.y1 = y1;
	}

	public float getX2() {
		return x2;
	}

	public void setX2(float x2) {
		this.x2 = x2;
	}

	public float getY2() {
		return y2;
	}

	public void setY2(float y2) {
		this.y2 = y2;
	}

	public float getX3() {
		return x3;
	}

	public void setX3(float x3) {
		this.x3 = x3;
	}

	public float getY3() {
		return y3;
	}

	public void setY3(float y3) {
		this.y3 = y3;
	}

	@Override
	public boolean inside(Point point) {
		float x = point.getX();
		float y = point.getY();
		float mx1 = x - x1;
		float my1 = y - y1;

		float mx2 = x - x2;
		float my2 = y - y2;

		float mx3 = x - x3;
		float my3 = y - y3;

		float a = mx1 * my2 - my1 * mx2;
		float b = mx2 * my3 - my2 * mx3;
		float c = mx3 * my1 - my3 * mx1;
		if ((a <= 0 && b <= 0 && c <= 0) || (a > 0 && b > 0 && c > 0)) {
			return true;
		} else {
			return false;
		}

	}

	/**
	 * 已知三边求面积（海伦公式）<br/>
	 * S=√[p(p-a)(p-b)(p-c)] <br/>
	 * p为半周长： p=(a+b+c)/2
	 */
	@Override
	public float calcArea() {
		double a = DistanceUtil.distance(x1, x2, y1, y2);
		double b = DistanceUtil.distance(x1, x3, y1, y3);
		double c = DistanceUtil.distance(x2, x3, y2, y3);
		double p = (a + b + c) / 2;
		double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
		return (float) s;
	}

	@Override
	public Rectangle getExternalRectangle() {
		float minx = Math.min(x1, Math.min(x2, x3));
		float miny = Math.min(y1, Math.min(y2, y3));
		float maxx = Math.max(x1, Math.max(x2, x3));
		float maxy = Math.max(y1, Math.max(y2, y3));
		Rectangle rect = new Rectangle(minx, maxy, maxx - minx, maxy - miny);
		return rect;

	}

}
