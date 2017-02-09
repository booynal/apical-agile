/**
 * PointCommand.java
 */
package com.apical.ziv.q9.commands;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import org.apache.commons.collections.CollectionUtils;

import com.apical.ziv.q9.interfaces.Command;
import com.apical.ziv.q9.shapes.ClosedShape;
import com.apical.ziv.q9.shapes.Point;
import com.apical.ziv.q9.shapes.memory.ShapeMemory;
import com.apical.ziv.q9.spring.SpringContext;
import com.apical.ziv.q9.utils.ThreadPool;

/**
 * @author ziv
 *
 */

public class PointCommand implements Command {

	private static ShapeMemory shapeMemory = SpringContext.getBean(ShapeMemory.class);

	private static ExecutorService threadPool = ThreadPool.getExecutorService();
	private static int threadSize = ThreadPool.getThreadSize();
	private Point point;

	public PointCommand(Point point) {
		this.point = point;
	}

	@Override
	public void execute() {
		long starttime = System.currentTimeMillis();
		List<ClosedShape> allShapes = shapeMemory.getAllShapes();
		if (CollectionUtils.isNotEmpty(allShapes)) {
			System.out.println(point);
			List<ClosedShape> filterdShapes = filter(allShapes);
			if (filterdShapes.isEmpty()) {
				System.out.println(String.format("There is no shapes cover '%s'", point));
				return;
			}
			System.out.println(String.format("There are '%s' shapes cover '%s'", filterdShapes.size(), point));
			double totalArea = 0;
			for (ClosedShape shape : filterdShapes) {
				totalArea += shape.calcArea();
			}
			System.out.println(String.format("total area: '%s'", totalArea));
			System.out.println("used time:" + (System.currentTimeMillis() - starttime) + "(ms)");
		}
	}

	private List<ClosedShape> filter(List<ClosedShape> allShapes) {
		class Filter implements Callable<List<ClosedShape>> {

			List<ClosedShape> allshapes;

			Filter(List<ClosedShape> allshapes) {
				this.allshapes = allshapes;
			}

			@Override
			public List<ClosedShape> call() throws Exception {
				List<ClosedShape> filterdShapes = new LinkedList<ClosedShape>();
				for (ClosedShape shape : allshapes) {
					if (shape.inside(point)) {
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
			submit.add(threadPool.submit(new Filter(allShapes.subList(step * i, Math.min(step * (i + 1), threadSize) - 1))));
		}
		List<ClosedShape> choosed = new LinkedList<ClosedShape>();
		for (int i = 0; i < threadSize; i++) {
			try {
				choosed.addAll(submit.get(i).get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		System.out.println("filterb : userd time :" + (System.currentTimeMillis() - starttime));
		return choosed;

	}
}
