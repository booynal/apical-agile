/**
 * DistanceUtil.java
 */
package com.apical.ziv.q9.utils;

import java.awt.geom.Line2D;

import com.apical.ziv.q9.shapes.Circle;
import com.apical.ziv.q9.shapes.ClosedShape;
import com.apical.ziv.q9.shapes.Donut;
import com.apical.ziv.q9.shapes.Point;
import com.apical.ziv.q9.shapes.Rectangle;
import com.apical.ziv.q9.shapes.Triangle;

/**
 * @author ziv
 *
 */
public class DistanceUtil {
	final static int precision=1000;
	public static double distance(Point p1, Point p2) {
		if (null == p1 || null == p2) {
			return -1;
		}

		return distance( p1.getX(),  p2.getX(),  p1.getY(),  p2.getY());
	}

	public static double distance(double x1, double x2, double y1, double y2) {
		return (double)Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}
	public static boolean interset(Rectangle r1 , Rectangle r2){
		double mx = Math.max(r1.getX(),r2.getX());
		double my= Math.max(r1.getY(), r2.getY());
		double nx = Math.min(r1.getX2(), r2.getX2());
		double ny =Math.min(r1.getY2(), r2.getY2());
		if(nx>=mx && ny>=my){
			return true;
		}else{
			return false;
		}
	}
	
	public static boolean interset( Rectangle rect,Circle circle){
		double x=rect.getX();
		double y=rect.getY();
		double width=rect.getWidth();
		double height=rect.getHeight();
		if(circle.inside(x, y)) return true;
		if(circle.inside(x+width, y)) return true;
		if(circle.inside(x+width, y+height)) return true;
		if(circle.inside(x, y+height)) return true;
		
		
		return false;
	}
	public static boolean interset( Rectangle rect,Donut donut){
	
		return false;
	}
	public static boolean interset( Rectangle rect,Triangle tri){
		return interset(tri,rect);
	}
	public static boolean interset(Triangle tri , Rectangle rect){
		//judge if two line interset
		
		double tx1=tri.getX1();
		double ty1=tri.getY1();
		double tx2=tri.getX2();
		double ty2=tri.getY2();
		double tx3=tri.getX3();
		double ty3=tri.getY3();
		
		double rx1=rect.getX();
		double ry1=rect.getY();
		double weight=rect.getWidth();
		double height=rect.getHeight();
		
		if (tri.inside(rx1, ry1)) return true;
		if (tri.inside(rx1+weight, ry1)) return true;
		if (tri.inside(rx1+weight, ry1+height)) return true;
		if (tri.inside(rx1, ry1+height)) return true;
		
		if(rect.inside(tx1, ty1)) return true;
		if(rect.inside(tx2, ty2)) return true;
		if(rect.inside(tx3, ty3)) return true;
		
		if(Line2D.linesIntersect(tx1, ty1, tx2, ty2, rx1, ry1, rx1+weight, ry1)) return true;
		if(Line2D.linesIntersect(tx1, ty1, tx2, ty2, rx1+weight, ry1, rx1+weight, ry1+height)) return true;
		if(Line2D.linesIntersect(tx1, ty1, tx2, ty2, rx1+weight, ry1+height, rx1, ry1+height)) return true;
		if(Line2D.linesIntersect(tx1, ty1, tx2, ty2, rx1, ry1+height, rx1, ry1)) return true;
		

		if(Line2D.linesIntersect(tx2, ty2, tx3, ty3, rx1, ry1, rx1+weight, ry1)) return true;
		if(Line2D.linesIntersect(tx2, ty2, tx3, ty3, rx1+weight, ry1, rx1+weight, ry1+height)) return true;
		if(Line2D.linesIntersect(tx2, ty2, tx3, ty3, rx1+weight, ry1+height, rx1, ry1+height)) return true;
		if(Line2D.linesIntersect(tx2, ty2, tx3, ty3, rx1, ry1+height, rx1, ry1)) return true;

		if(Line2D.linesIntersect(tx3, ty3, tx1, ty1, rx1, ry1, rx1+weight, ry1)) return true;
		if(Line2D.linesIntersect(tx3, ty3, tx1, ty1, rx1+weight, ry1, rx1+weight, ry1+height)) return true;
		if(Line2D.linesIntersect(tx3, ty3, tx1, ty1, rx1+weight, ry1+height, rx1, ry1+height)) return true;
		if(Line2D.linesIntersect(tx3, ty3, tx1, ty1, rx1, ry1+height, rx1, ry1)) return true;

		
		return false;
	}
	public static Rectangle unionRect(Rectangle[] rs){
		if(rs==null){ return null;}
		if(rs.length==0) {return null;}
		if(rs.length==1) {return rs[0];}
		double mx = rs[0].getX();
		double my = rs[0].getY();
		double nx = rs[0].getX2();
		double ny = rs[0].getY2();
		for(int i=1 ; i<rs.length;i++){
			mx =Math.min(mx, rs[i].getX());
			my=Math.min(my, rs[i].getY());
			nx=Math.max(nx, rs[i].getX2());
			ny=Math.max(ny, rs[i].getY2());
		}
		return new Rectangle(mx,my,nx-mx,ny-my);
	}
	public static double calcUnionArea(ClosedShape[] ss){
		Rectangle[] rs = new Rectangle[ss.length];
		for(int i=0 ; i<ss.length;i++){
			rs[i] = ss[i].getExternalRectangle();
		}
		Rectangle rect = unionRect(rs);
		
		double width = rect.getWidth();
		double height = rect.getHeight();
		
		double x = rect.getX();
		double y = rect.getY();
		double widthStep = width/precision;
		double heighStep = height/precision;
		int hit=0;
		for(int i=0; i<precision ; i++){
			double xx = x+ i*widthStep;
			for(int j=0; j<precision;j++){
				double yy = y + j*heighStep;
				for(ClosedShape s : ss){
					if(s.inside(xx,yy)){
						hit++;
						break;
					}
				}
			}
		}
		double s = width*height;
		s = s * hit / precision /precision;
		return s;
	}
	public static boolean interset(ClosedShape s1 , ClosedShape s2){
		Rectangle rect = s1.getExternalRectangle();
		double width = rect.getWidth();
		double height = rect.getHeight();
		double x = rect.getX();
		double y = rect.getY();
		double widthStep = width/precision;
		double heighStep = height/precision;
		for(int i=0; i<precision ; i++){
			double xx = x+ i*widthStep;
			for(int j=0; j<precision;j++){
				double yy = y + j*heighStep;
				if(s1.inside(xx,yy) && s2.inside(xx,yy)){
					return true;
				}
			}
		}
		return false;
	}
	//interset area
	public static double calcIntersetArea(ClosedShape s1 , ClosedShape s2){
		Rectangle rect1 = s1.getExternalRectangle();
		Rectangle rect2 = s2.getExternalRectangle();
		Rectangle rect;
		if (rect1.calcArea()<rect2.calcArea()){
			rect=rect1;
		}else{
			rect=rect2;
		}
		double width = rect.getWidth();
		double height = rect.getHeight();
		
		double x = rect.getX();
		double y = rect.getY();
		double widthStep = width/precision;
		double heighStep = height/precision;
		int hit=0;
		for(int i=0; i<precision ; i++){
			double xx = x+ i*widthStep;
			for(int j=0; j<precision;j++){
				double yy = y + j*heighStep;
				if(s1.inside(xx,yy) && s2.inside(xx,yy)){
					hit++;
				}
			}
		}
		double s = width*height;
		s = s * hit / precision /precision;
		return s;
	}

	public static boolean linesIntersect(double x1, double y1,
			double x2, double y2,
			double x3, double y3,
			double x4, double y4){
		return Line2D.linesIntersect(x1, y1, x2, y2, x3, y3, x4, y4);
	}
}
