/**
 * Donut.java
 */
package com.apical.ziv.q9.shapes;

import com.apical.ziv.q9.consts.ShapeTypeConsts;
import com.apical.ziv.q9.utils.DistanceUtil;

/**
 * 圆环，从圆继承，圆的半径为圆环的外径
 *
 * @author ziv
 *
 */
public class Donut extends Circle {

	private float outterRadius;

	public Donut(float x, float y, float innerRadius, float outterRadius) {
		super(ShapeTypeConsts.DONUT, x, y, innerRadius);
		this.outterRadius = outterRadius;
	}

	public float getInnerRadius() {
		return super.getRadius();
	}

	public void setInnerRadius(float innerRadius) {
		super.setRadius(innerRadius);
	}

	public float getOutterRadius() {
		return outterRadius;
	}

	public void setOutterRadius(float outterRadius) {
		this.outterRadius = outterRadius;
	}

	@Override
	@Deprecated
	public float getRadius() {
		return getInnerRadius();
	}

	@Override
	@Deprecated
	public void setRadius(float innerRadius) {
		setInnerRadius(innerRadius);
	}

	@Override
	public String toString() {
		return String.format("shape %s: %s with centre at (%.2f, %.2f) and innerRadius %.2f and outterRadius %.2f", getIdLong(), getType(), getX(), getY(), getInnerRadius(), getOutterRadius());
	}

	@Override
	public boolean inside(Point point) {
		double distance = DistanceUtil.distance(getX(), point.getX(), getY(), point.getY());
		return distance <= getOutterRadius() && distance >= getInnerRadius();
	}

	@Override
	public float calcArea() {
		return (float) (Math.PI * Math.pow(getOutterRadius(), 2) - Math.PI * Math.pow(getInnerRadius(), 2));
	}
}
