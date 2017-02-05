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
public class Triangle extends Shape {

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
		return String.format("shape %s: %s with point ont at (%.2f, ­%.2f) and point two at (%.2f, ­%.2f) and point three at (%.2f, ­%.2f)", getIdLong(), getName(), x1, y1, x2, y2, x3, y3);
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
		// FIXME 不知道三角形是如何判断一个点是否在三角形内的
		return false;
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

}
