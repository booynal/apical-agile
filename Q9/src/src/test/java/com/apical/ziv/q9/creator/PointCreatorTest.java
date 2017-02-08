/**
 * PointCreatorTest.java
 */
package com.apical.ziv.q9.creator;

import org.junit.Assert;
import org.junit.Test;

import com.apical.ziv.q9.exceptions.ShapeCreateException;
import com.apical.ziv.q9.interfaces.Shape;
import com.apical.ziv.q9.shapes.Circle;
import com.apical.ziv.q9.shapes.Donut;
import com.apical.ziv.q9.shapes.Rectangle;
import com.apical.ziv.q9.shapes.Square;
import com.apical.ziv.q9.shapes.creators.PointCreator;

/**
 * @author ziv
 *
 */
public class PointCreatorTest {

	private PointCreator pointCreator = new PointCreator();

	@Test
	public void test() throws ShapeCreateException {
		Shape create = pointCreator.create("0,0");
		System.out.println(create);
		Assert.assertNotNull(create);
		Shape create2 = pointCreator.create("(0, 0)");
		System.out.println(create2);
		Assert.assertNotNull(create2);
	}
	@Test
	public void testOverlap_rect_rect(){
		Rectangle r1 = new Rectangle(0,0,4,4);
		Rectangle r2 = new Rectangle(1,1,1,1);
		Assert.assertTrue(r1.intersect(r2));
	}
	
	@Test
	public void testOverlap_circle_rect(){
		Circle r1 = new Circle(0,0,4);
		Rectangle r2 = new Rectangle(1,1,1,1);
		Assert.assertTrue(r1.intersect(r2));
	}
	@Test
	public void testOverlap_circle_square(){
		Circle r1 = new Circle(0,0,4);
		Square r2 = new Square(1,1,1);
		Assert.assertTrue(r1.intersect(r2));
	}
	
	@Test
	public void testOverlap_donut_donut(){
		Donut r1 =null;
		Donut r2 =null;
		r1=new Donut(0,0,3,4);
		r2=new Donut(0,0,1,2);
		Assert.assertFalse(r1.intersect(r2));
		
		r1=new Donut(0,0,3,4);
		r2=new Donut(0,0,0,2);
		Assert.assertFalse(r1.intersect(r2));
		
		r1=new Donut(0,0,2,4);
		r2=new Donut(0,0,1,3);
		Assert.assertTrue(r1.intersect(r2));
		
		
		
		
	}
	
}
