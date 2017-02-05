/**
 * ShapeCommand.java
 */
package com.apical.ziv.q9.commands;

import com.apical.ziv.q9.consts.ErrorConsts;
import com.apical.ziv.q9.consts.ShapeTypeConsts;
import com.apical.ziv.q9.exceptions.ShapeException;
import com.apical.ziv.q9.interfaces.Command;
import com.apical.ziv.q9.shapes.Point;
import com.apical.ziv.q9.shapes.Shape;
import com.apical.ziv.q9.shapes.creators.ShapeFactory;
import com.apical.ziv.q9.shapes.memory.ShapeMemory;
import com.apical.ziv.q9.spring.SpringContext;

/**
 * @author ziv
 *
 */
public class ShapeCommand implements Command {

	private static ShapeFactory shapeFactory = SpringContext.getBean(ShapeFactory.class);
	private static ShapeMemory shapeMemory = SpringContext.getBean(ShapeMemory.class);

	private String input;

	public ShapeCommand(String input) {
		this.input = input;
	}

	@Override
	public void execute() throws ShapeException {
		Shape shape = shapeFactory.create(input);
		if (null != shape) {
			if (ShapeTypeConsts.isPoint(shape.getName())) {
				new PointCommand((Point) shape).execute();
			} else {
				shapeMemory.addShape(shape);
				System.out.println(shape);
			}
		} else {
			throw new ShapeException(String.format("%s: %s", ErrorConsts.ERROR_005, input));
		}
	}

}
