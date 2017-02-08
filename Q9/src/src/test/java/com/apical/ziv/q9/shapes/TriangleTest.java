package com.apical.ziv.q9.shapes;

import static org.junit.Assert.*;

import org.junit.Test;

public class TriangleTest {

	@Test
	public void testOverLap() {
		Triangle tri1 = new Triangle(-3,-0.01f,3,-0.01f,0,2);
		Triangle tri2 = new Triangle(-1,0,1,0,0,1);
		assertTrue(tri1.isOverLap(tri2));
		assertFalse(tri2.isOverLap(tri1));
		
		tri1 = new Triangle(0,0,4,0,0,4);
		Circle cir = new Circle(1,1,0.99f);
		assertTrue(tri1.isOverLap(cir));
		assertFalse(cir.isOverLap(tri1));
		Donut dou = new Donut(1,1,0.8f,0.99f);
		assertTrue(tri1.isOverLap(cir));
		assertFalse(cir.isOverLap(tri1));
		
		
	}

}
