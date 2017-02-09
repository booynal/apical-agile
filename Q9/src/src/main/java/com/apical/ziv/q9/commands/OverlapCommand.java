/**
 * OverlapCommand.java
 */
package com.apical.ziv.q9.commands;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import com.apical.ziv.q9.consts.ErrorConsts;
import com.apical.ziv.q9.exceptions.ShapeException;
import com.apical.ziv.q9.interfaces.Command;
import com.apical.ziv.q9.interfaces.Shape;
import com.apical.ziv.q9.shapes.ClosedShape;
import com.apical.ziv.q9.shapes.creators.ShapeFactory;
import com.apical.ziv.q9.shapes.memory.ShapeMemory;
import com.apical.ziv.q9.spring.SpringContext;
import com.apical.ziv.q9.utils.ThreadPool;

/**
 * @author ziv
 *
 */
public class OverlapCommand implements Command {

	private static ShapeFactory shapeFactory = SpringContext.getBean(ShapeFactory.class);
	private static ShapeMemory shapeMemory = SpringContext.getBean(ShapeMemory.class);

	private static ExecutorService threadPool = ThreadPool.getExecutorService();
	private static int threadSize = ThreadPool.getThreadSize();

	private String input;

	public OverlapCommand(String input) {
		this.input = input;
	}

	@Override
	public void execute() throws ShapeException {
		Shape shape = shapeFactory.create(input);
		if (null != shape && shape instanceof ClosedShape) {
			ClosedShape closedShape = (ClosedShape) shape;
			System.out.println(closedShape);

			List<ClosedShape> choosedShape = filter(shapeMemory.getAllShapes(), closedShape);
			if (choosedShape.isEmpty()) {
				System.out.println("No shape overlap " + closedShape);
				return;
			} else {
				System.out.println("The size of Overlap shape:" + choosedShape.size());
				return;
			}
		} else {
			throw new ShapeException(String.format("%s: %s", ErrorConsts.ERROR_005, input));
		}
	}

	private List<ClosedShape> filter(List<ClosedShape> allShapes, ClosedShape cshape) {
		class Filter implements Callable<List<ClosedShape>> {

			List<ClosedShape> allshapes;
			ClosedShape cshape;

			Filter(List<ClosedShape> allshapes, ClosedShape cshape) {
				this.allshapes = allshapes;
				this.cshape = cshape;
			}

			@Override
			public List<ClosedShape> call() throws Exception {
				List<ClosedShape> filterdShapes = new LinkedList<ClosedShape>();
				for (ClosedShape shape : allshapes) {
					if (shape.isOverLap(cshape)) {
						filterdShapes.add(shape);
					}
				}
				return filterdShapes;
			}
		}
		long starttime = System.currentTimeMillis();
		List<Future<List<ClosedShape>>> submit = new ArrayList<>();
		int step = allShapes.size() / threadSize;
		for (int i = 0; i < threadSize; i++) {
			submit.add(threadPool.submit(new Filter(allShapes.subList(step * i, Math.min(step * (i + 1), threadSize - 1)), cshape)));
		}
		List<ClosedShape> choosed = new LinkedList<ClosedShape>();
		for (int i = 0; i < threadSize; i++) {
			try {
				choosed.addAll(submit.get(i).get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		System.out.println("filter : userd time :" + (System.currentTimeMillis() - starttime));
		return choosed;

	}

}
