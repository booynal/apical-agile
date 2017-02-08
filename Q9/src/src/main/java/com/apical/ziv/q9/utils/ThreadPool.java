package com.apical.ziv.q9.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
	private static ExecutorService executorService;
	private static int threadSize;
	static{
		int availableProcessors = Runtime.getRuntime().availableProcessors();
		if(availableProcessors>=2){
			threadSize= availableProcessors-2 ;
		}else{
			threadSize = availableProcessors;
		}
		executorService= Executors.newFixedThreadPool(threadSize);
	}
	public static ExecutorService getExecutorService() {
		return executorService;
	}
	public static int getThreadSize() {
		return threadSize;
	}

	
}
