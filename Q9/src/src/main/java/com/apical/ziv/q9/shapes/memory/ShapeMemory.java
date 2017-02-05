/**
 * ShapeMemory.java
 */
package com.apical.ziv.q9.shapes.memory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.apical.ziv.q9.shapes.Shape;

/**
 * @author ziv
 *
 */
@Component
public class ShapeMemory {

	private List<Shape> shapes = new ArrayList<>();

	public void addShape(Shape shape) {
		shapes.add(shape);
	}

	public List<Shape> getAllShapes() {
		return new ArrayList<>(shapes);
	}

}
