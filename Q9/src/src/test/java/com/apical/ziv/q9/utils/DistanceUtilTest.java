package com.apical.ziv.q9.utils;

import static org.junit.Assert.*;

import java.awt.geom.Line2D;

import org.junit.Assert;
import org.junit.Test;

import com.apical.ziv.q9.shapes.ClosedShape;
import com.apical.ziv.q9.shapes.Rectangle;

public class DistanceUtilTest {

	@Test
	public void testDistancePointPoint() {
		// fail("Not yet implemented");
	}

	@Test
	public void testDistancedoubledoubledoubledouble() {
		// fail("Not yet implemented");
	}

	@Test
	public void testIntersetRectangleRectangle() {
		// fail("Not yet implemented");
	}

	@Test
	public void testIntersetClosedShapeClosedShape() {
		Rectangle rect1 = new Rectangle(0, 0, 4, 4);
		Rectangle rect2 = new Rectangle(0, 0, 2, 2);
		Assert.assertTrue(DistanceUtil.interset(rect1, rect2));

	}

	@Test
	public void testcalcIntersetArea() {
		Rectangle rect1 = new Rectangle(0, 0, 4, 4);
		Rectangle rect2 = new Rectangle(0, 0, 2, 2);
		Assert.assertTrue(DistanceUtil.calcIntersetArea(rect1, rect2) == 4);

	}

	@Test
	public void testPointSeg() {
		double ptSegDist = Line2D.ptSegDist(0, 1, 1, 1, 0, 0);
		assertTrue(ptSegDist == 1);
		double ptSegDist2 = Line2D.ptSegDist(0.5, 1, 1, 1, 0, 0);
		assertTrue(Line2D.ptSegDist(0.5, 1, 1, 1, 0, 0) > 1);
	}

	@Test
	public void TestcalcUnionArea() {
		ClosedShape[] rs = new Rectangle[1];
		rs[0] = new Rectangle(0, 0, 4, 4);

		Assert.assertTrue(Math.abs(DistanceUtil.calcUnionArea(rs) - 16) < 0.1);
		rs = new Rectangle[2];
		rs[0] = new Rectangle(0, 0, 4, 4);
		rs[1] = new Rectangle(-1, -1, 1, 1);
		Assert.assertTrue(Math.abs(DistanceUtil.calcUnionArea(rs) - 17) < 0.1);
		rs = new Rectangle[3];
		rs[0] = new Rectangle(0, 0, 4, 4);
		rs[1] = new Rectangle(-1, -1, 1, 1);
		rs[2] = new Rectangle(-1, -1, 1, 1);
		Assert.assertTrue(Math.abs(DistanceUtil.calcUnionArea(rs) - 17) < 0.1);

		rs[0] = new Rectangle(0, 0, 1, 1);
		rs[1] = new Rectangle(1, 1, 1, 1);
		rs[2] = new Rectangle(-1, -1, 1, 1);
		Assert.assertTrue(Math.abs(DistanceUtil.calcUnionArea(rs) - 3) < 0.1);

		rs[0] = new Rectangle(0, 0, 2, 2);
		rs[1] = new Rectangle(1, 1, 2, 2);
		rs[2] = new Rectangle(2, 2, 2, 2);
		Assert.assertTrue(Math.abs(DistanceUtil.calcUnionArea(rs) - 10) < 0.1);

	}

}
