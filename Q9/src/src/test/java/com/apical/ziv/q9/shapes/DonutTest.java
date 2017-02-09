package com.apical.ziv.q9.shapes;

import static org.junit.Assert.*;

import org.junit.Test;

public class DonutTest {

	@Test
	public void testInsideDoubleDouble() {
		fail("Not yet implemented");
	}

	@Test
	public void testOverLapRectangle() {
		Donut d = new Donut(0, 0, 2, 5);
		Rectangle r = null;
		r = new Rectangle(-1, -1, 2, 2);
		assertFalse(d.overLap(r));
		r = new Rectangle(1, -1, 2, 2);
		assertFalse(d.overLap(r));
		r = new Rectangle(2, -1, 2, 2);
		assertTrue(d.overLap(r));
		r = new Rectangle(3, -1, 2, 2);
		assertFalse(d.overLap(r));
		r = new Rectangle(6, -1, 2, 2);
		assertFalse(d.overLap(r));

	}

	@Test
	public void testOverLapCircle() {
		Donut d = new Donut(0, 0, 2, 5);
		Circle r = null;
		r = new Circle(0, 0, 1);
		assertFalse(d.overLap(r));
		r = new Circle(1, 0, 2);
		assertFalse(d.overLap(r));
		r = new Circle(3.5, 0, 1);
		assertTrue(d.overLap(r));
		r = new Circle(5, 0, 1);
		assertFalse(d.overLap(r));
		r = new Circle(6, 0, 0.5);
		assertFalse(d.overLap(r));

	}

	@Test
	public void testOverLapTriangle() {
		Donut d = new Donut(0, 0, 2, 8);
		Triangle r = null;
		r = new Triangle(-1, 0, 1, 0, 0, 1);
		assertFalse(d.overLap(r));
		r = new Triangle(4, 0, 8, 0, 0, 4);
		assertTrue(d.overLap(r));
		r = new Triangle(-4, -3, 4, -3, 0, 4);
		assertFalse(d.overLap(r));

	}

	@Test
	public void testOverLapDonut() {

		Donut d = new Donut(0, 0, 2, 8);
		Donut r = null;
		r = new Donut(0, 0, 2, 8);
		assertTrue(d.overLap(r));
		r = new Donut(0, 0, 3, 6);
		assertTrue(d.overLap(r));
		r = new Donut(0, 0, 1, 5);
		assertFalse(d.overLap(r));
		r = new Donut(5, 0, 1, 3.1);
		assertFalse(d.overLap(r));

	}

	@Test
	public void testIntersect() {
		fail("Not yet implemented");
	}

	@Test
	public void testCalcArea() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetExternalRectangle() {
		fail("Not yet implemented");
	}

	@Test
	public void testDonutDoubleDoubleDoubleDouble() {
		fail("Not yet implemented");
	}

	@Test
	public void testDonutStringDoubleDoubleDoubleDouble() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetX() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetY() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetInnerRadius() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetOutterRadius() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetOutterRadius() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
