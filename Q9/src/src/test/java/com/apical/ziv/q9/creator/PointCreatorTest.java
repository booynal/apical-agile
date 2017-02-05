/**
 * PointCreatorTest.java
 */
package com.apical.ziv.q9.creator;

import org.junit.Assert;
import org.junit.Test;

import com.apical.ziv.q9.exceptions.ShapeCreateException;
import com.apical.ziv.q9.interfaces.Shape;
import com.apical.ziv.q9.shapes.ClosedShape;
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

}
