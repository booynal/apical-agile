/**
 * PointCommand.java
 */
package com.apical.ziv.q9.commands;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.apical.ziv.q9.interfaces.Command;
import com.apical.ziv.q9.shapes.ClosedShape;
import com.apical.ziv.q9.shapes.Point;
import com.apical.ziv.q9.shapes.memory.ShapeMemory;
import com.apical.ziv.q9.spring.SpringContext;

/**
 * @author ziv
 *
 */

public class PointCommand implements Command {

	private static ShapeMemory shapeMemory = SpringContext.getBean(ShapeMemory.class);

	private Point point;

	public PointCommand(Point point) {
		this.point = point;
	}

	@Override
	public void execute() {
		List<ClosedShape> allShapes = shapeMemory.getAllShapes();
		if (CollectionUtils.isNotEmpty(allShapes)) {
			System.out.println(point);
			List<ClosedShape> filterdShapes = filter(allShapes);
			System.out.println(String.format("There are '%s' shapes cover '%s'", filterdShapes.size(), point));
			float totalArea = 0;
			for (ClosedShape shape : filterdShapes) {
				float area = shape.calcArea();
				totalArea += area;
				System.out.println(String.format("shape: '%s', area: '%s'", shape, area));
			}
			System.out.println(String.format("total area: '%s'", totalArea));
		}
	}

	private List<ClosedShape> filter(List<ClosedShape> allShapes) {
		List<ClosedShape> filterdShapes = new ArrayList<>();
		for (ClosedShape shape : allShapes) {
			if (shape.inside(point)) {
				filterdShapes.add(shape);
			}
		}
		return filterdShapes;
	}

}
