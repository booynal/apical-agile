/**
 * ShapeMemory.java
 */
package com.apical.ziv.q9.shapes.memory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.apical.ziv.q9.shapes.ClosedShape;

/**
 * @author ziv
 *
 */
@Component
public class ShapeMemory {

	private List<ClosedShape> shapes = new ArrayList<>();

	public void addShape(ClosedShape shape) {
		shapes.add(shape);
	}

	public List<ClosedShape> getAllShapes() {
		return new ArrayList<>(shapes);
	}

}
