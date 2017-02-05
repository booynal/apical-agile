/**
 * Shape.java
 */
package com.apical.ziv.q9.shapes;

import java.util.concurrent.atomic.AtomicLong;

import com.apical.ziv.q9.interfaces.Shape;

/**
 * 图形
 *
 * @author ziv
 *
 */
public abstract class ClosedShape implements Shape {

	private static AtomicLong idGenerator = new AtomicLong();

	private long idLong;
	private String type;

	protected ClosedShape(String type) {
		this.type = type;
		idLong = idGenerator.incrementAndGet();
	}

	@Override
	public String toId() {
		return String.format("%s_%s", type, idLong);
	}

	@Override
	public String getType() {
		return type;
	}

	public void setType(String name) {
		type = name;
	}

	public long getIdLong() {
		return idLong;
	}

	public void setIdLong(long idLong) {
		this.idLong = idLong;
	}

	/**
	 * 判断给定的点是否在图形内
	 *
	 * @param point
	 *            给定的点
	 * @return 是否在图形内
	 */
	public abstract boolean inside(Point point);

	/**
	 * 计算图形的面积
	 */
	public abstract float calcArea();

	public abstract Rectangle getExternalRectangle();
}
