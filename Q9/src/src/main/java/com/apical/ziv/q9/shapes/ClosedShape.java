/**
 * Shape.java
 */
package com.apical.ziv.q9.shapes;

import java.util.concurrent.atomic.AtomicLong;

import com.apical.ziv.q9.interfaces.Shape;
import com.apical.ziv.q9.utils.DistanceUtil;

/**
 * 图形
 *
 * @author ziv
 *
 */
public abstract class ClosedShape implements Shape {

	private long id;
	private String type;

	protected ClosedShape(String type) {
		this.type = type;
	}

	@Override
	public String getType() {
		return type;
	}

	public void setType(String name) {
		type = name;
	}

	@Override
	public long getId() {
		return id;
	}

	public void setId(long idLong) {
		id = idLong;
	}

	/**
	 * 判断给定的点是否在图形内
	 *
	 * @param point
	 *            给定的点
	 * @return 是否在图形内
	 */
	public  boolean inside(Point point){
		return inside(point.getX() , point.getY());
	}
	public abstract boolean inside(double x,double y);
	
	public boolean isOverLap(ClosedShape shape){
		Rectangle thisExtRect = getExternalRectangle();
		Rectangle thatExtRect= shape.getExternalRectangle();
		boolean intersect = thisExtRect.intersect(thatExtRect);
		if(!intersect) return false;
		return overLap(shape);
		
	}
	protected boolean overLap(ClosedShape shape) {

		if(shape instanceof Triangle){
			return overLap((Triangle) shape);
		}else if(shape instanceof Rectangle){
			return overLap((Rectangle)shape);
		}else if(shape instanceof Donut){
			return overLap((Donut)shape);
		}else if(shape instanceof Circle){
			return overLap((Circle)shape);
		}else {
			if(Math.abs(DistanceUtil.calcIntersetArea(this,shape)- shape.calcArea())<0.01){
				return true;
			}else {
				return false;
			}
			
		}
	
	}
	
	protected abstract boolean overLap(Rectangle shape);
	protected abstract boolean overLap(Circle shape);
	protected abstract boolean overLap(Triangle shape);
	protected abstract boolean overLap(Donut shape);
	
	protected abstract boolean intersect(ClosedShape shape);

	/**
	 * 计算图形的面积
	 */
	public abstract double calcArea();

	public abstract Rectangle getExternalRectangle();
}
