package com.apical.ziv.q9.shapes;

import static org.junit.Assert.*;

import org.junit.Test;

public class RectangleTest {

	@Test
	public void testOverLapRectangle() {
		Rectangle rect1 = new Rectangle(0,0,4,4);
		Rectangle rect2 = new Rectangle(0,0,4,4);
		assertTrue(rect2.overLap(rect1));
		assertTrue(rect1.overLap(rect2));
		rect2 = new Rectangle(1,1,2,2);
		assertFalse(rect2.overLap(rect1));
		assertTrue(rect1.overLap(rect2));
		
		rect2 = new Rectangle(-1,-1,4,4);
		assertFalse(rect2.overLap(rect1));
		assertFalse(rect1.overLap(rect2));
		
	}

	@Test
	public void testOverLapCircle() {
		Rectangle rect = new Rectangle(0,0,4,4);
		Circle c =null;
		c=new Circle(2,2,2);
		assertTrue(rect.overLap(c));
		c = new Circle(2,2,2.1);
		assertFalse(rect.overLap(c));
		
	}

	@Test
	public void testOverLapTriangle() {
		Rectangle rect = new Rectangle(0,0,4,4);
		Triangle tri ;
		tri= new Triangle(0,0,0,2,1,1);
		assertTrue(rect.overLap(tri));
		tri= new Triangle(-1,0,0,2,1,1);
		assertFalse(rect.overLap(tri));
		
		tri= new Triangle(-4,0,8,0,2,6);
		assertFalse(rect.overLap(tri));
		assertFalse(tri.overLap(rect));
		
	}

	@Test
	public void testOverLapDonut() {

		Rectangle rect = new Rectangle(0,0,4,4);
		Donut c =null;
		c=new Donut(2,2,1,2);
		assertTrue(rect.overLap(c));
		c = new Donut(2,2,1,2.1);
		assertFalse(rect.overLap(c));
		
		}

}
