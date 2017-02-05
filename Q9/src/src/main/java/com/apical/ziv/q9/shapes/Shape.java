/**
 * Shape.java
 */
package com.apical.ziv.q9.shapes;

import java.util.concurrent.atomic.AtomicLong;

import com.apical.ziv.q9.interfaces.Idable;

/**
 * 图形
 *
 * @author ziv
 *
 */
public abstract class Shape implements Idable {

	private static AtomicLong idGenerator = new AtomicLong();

	private long idLong;
	private String name;

	protected Shape(String name) {
		this.name = name;
		idLong = idGenerator.incrementAndGet();
	}

	protected Shape(String name, boolean idNotIncrement) {
		this.name = name;
	}

	@Override
	public String toId() {
		return String.format("%s_%s", name, idLong);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
}
