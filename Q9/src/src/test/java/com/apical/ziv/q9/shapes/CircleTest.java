package com.apical.ziv.q9.shapes;

import static org.junit.Assert.*;

import org.junit.Test;

public class CircleTest {

	@Test
	public void testOverLapRectangle() {
		Circle c = new Circle(0, 0, 4);
		Rectangle r = new Rectangle(0, 0, 2, 2);
		assertTrue(c.overLap(r));
		r = new Rectangle(-4, -4, 8, 8);
		assertFalse(c.overLap(r));
	}

	@Test
	public void testOverLapCircle() {

		Circle c = new Circle(0, 0, 4);
		Circle r = null;
		r = new Circle(0, 0, 8);
		assertFalse(c.overLap(r));
		r = new Circle(0, 0, 6);
		assertFalse(c.overLap(r));
		r = new Circle(0, 0, 2);
		assertTrue(c.overLap(r));
		r = new Circle(3, 0, 0.1);
		assertTrue(c.overLap(r));
		r = new Circle(3, 0, 1.1);
		assertFalse(c.overLap(r));

	}

	@Test
	public void testOverLapTriangle() {
		Circle c = new Circle(0, 0, 4);
		Triangle tri = null;
		tri = new Triangle(-2, -2, 2, -2, 0, 2);
		assertTrue(c.overLap(tri));
		tri = new Triangle(-4, -4, 4, -4, 0, 0);
		assertFalse(c.overLap(tri));

	}

	@Test
	public void testOverLapDonut() {

		Circle c = new Circle(0, 0, 4);
		Donut r = null;
		r = new Donut(0, 0, 2, 8);
		assertFalse(c.overLap(r));
		r = new Donut(0, 0, 3, 6);
		assertFalse(c.overLap(r));
		r = new Donut(0, 0, 1, 2);
		assertTrue(c.overLap(r));
		r = new Donut(3, 0, 0.5, 1);
		assertTrue(c.overLap(r));
		r = new Donut(3, 0, 0.5, 1.1);
		assertFalse(c.overLap(r));

	}

}
