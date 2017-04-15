package com.multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Multithreading_3 implements Callable<String>{

	public static void main(String[] args) {
		Multithreading_3 multithreading_3 = new Multithreading_3();
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		Future<String> future = executorService.submit(multithreading_3);
		try {
		    System.out.println(future.get());
		} catch (InterruptedException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		} catch (ExecutionException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		}
	}		

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("From Call function");
		return "Vipul";
	}

}
