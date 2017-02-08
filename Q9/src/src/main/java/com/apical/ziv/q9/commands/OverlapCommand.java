/**
 * ShapeCommand.java
 */
package com.apical.ziv.q9.commands;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

import com.apical.ziv.q9.consts.ErrorConsts;
import com.apical.ziv.q9.consts.ShapeTypeConsts;
import com.apical.ziv.q9.exceptions.ShapeException;
import com.apical.ziv.q9.interfaces.Command;
import com.apical.ziv.q9.interfaces.Shape;
import com.apical.ziv.q9.shapes.ClosedShape;
import com.apical.ziv.q9.shapes.Point;
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
	private static ExecutorService threadPool=ThreadPool.getExecutorService();
	private static int threadSize = ThreadPool.getThreadSize();
	private String input;

	public OverlapCommand(String input) {
		this.input = input;
	}

	@Override
	public void execute() throws ShapeException {
		
		Shape shape = shapeFactory.create(input);
		if (null != shape && shape instanceof ClosedShape) {
				ClosedShape cshape =(ClosedShape) shape;
				System.out.println(cshape);
				
				List<ClosedShape> choosedShape = filter(shapeMemory.getAllShapes(),cshape);
				if(choosedShape.isEmpty()){
					System.out.println("No shape overlap " + cshape);
					return ;
				}else{
					System.out.println("The size of Overlap shape:" + choosedShape.size());
					for(ClosedShape s : choosedShape){
						//System.out.println(s);
					}	
					return ;
				}
				
		} else {
			throw new ShapeException(String.format("%s: %s", ErrorConsts.ERROR_005, input));
		}
	}
	
	private List<ClosedShape> filter(List<ClosedShape> allShapes,ClosedShape cshape) {
		class Filter implements Callable<List<ClosedShape>>{
			List<ClosedShape> allshapes ;
			ClosedShape cshape ;
			Filter(List<ClosedShape> allshapes ,ClosedShape cshape){
				this.allshapes= allshapes;
				this.cshape =cshape;
			}
			public List<ClosedShape> call() throws Exception{
				List<ClosedShape> filterdShapes = new LinkedList<ClosedShape>();
				for(ClosedShape shape : allshapes){
					 if (shape.isOverLap(cshape)) {
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
			
			task = new Filter(sAllshapes,cshape);
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
		System.out.println("filter : userd time :" + (System.currentTimeMillis() - starttime));
		return choosed;
				
	}


}
