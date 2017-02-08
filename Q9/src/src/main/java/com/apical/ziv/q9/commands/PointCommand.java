/**
 * PointCommand.java
 */
package com.apical.ziv.q9.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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

	private static ExecutorService threadPool=ThreadPool.getExecutorService();
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
			if(filterdShapes.isEmpty()){
				System.out.println(String.format("There is no shapes cover '%s'", point));
				return;
			}
			System.out.println(String.format("There are '%s' shapes cover '%s'", filterdShapes.size(), point));
			double totalArea = 0;
			for (ClosedShape shape : filterdShapes) {
				double area = shape.calcArea();
				totalArea += area;
				//System.out.println(String.format("shape: '%s', area: '%s'", shape, area));
			}
			System.out.println(String.format("total area: '%s'", totalArea));
			System.out.println("used time:" +( System.currentTimeMillis() -starttime) + "(ms)");
		}
	}

	private List<ClosedShape> filterb(List<ClosedShape> allShapes) {
		List<ClosedShape> filterdShapes = new ArrayList<>();
		for (ClosedShape shape : allShapes) {
			if (shape.inside(point)) {
				filterdShapes.add(shape);
			}
		}
		return filterdShapes;
	}
	private List<ClosedShape> filter(List<ClosedShape> allShapes) {
		class Filter implements Callable<List<ClosedShape>>{
			List<ClosedShape> allshapes ;
			Filter(List<ClosedShape> allshapes){
				this.allshapes= allshapes;
			}
			public List<ClosedShape> call() throws Exception{
				List<ClosedShape> filterdShapes = new LinkedList<ClosedShape>();
				for(ClosedShape shape : allshapes){
					 if (shape.inside(point)) {
							filterdShapes.add(shape);
						}
				}
				return filterdShapes;
			}
		}
		long starttime = System.currentTimeMillis();
		List<ClosedShape> sAllshapes = null;
		Callable<List<ClosedShape>> task=null;
		Future<List<ClosedShape>>[] submit = new Future[threadSize];
		int size = allShapes.size();
		int step = size/threadSize;
		for(int i=0 ; i<threadSize; i++){
			if(i+1==threadSize){
				sAllshapes =allShapes.subList(step*i, size);	
			}else{
				sAllshapes =allShapes.subList(step*i, step*(i+1));
			}
			
			task = new Filter(sAllshapes);
			submit[i]=threadPool.submit(task);
		}
		List<ClosedShape> choosed = new LinkedList<ClosedShape>();
		for(int i=0 ; i<threadSize; i++){
			try {
				List<ClosedShape> list = submit[i].get();
				choosed.addAll(list);
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("filterb : userd time :" + (System.currentTimeMillis() - starttime));
		return choosed;
				
	}
}
