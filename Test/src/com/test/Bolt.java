package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Bolt implements Callable<Integer>{
	
	ExecutorService executorService = Executors.newCachedThreadPool();
	
	
	public static void main(String[] args){
	
		Bolt bolt = new Bolt();
		List<Integer> list = new ArrayList<>();
		
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		
		for(int i=0;i<list.size();i++){
			if(i==2) {
				list.remove(2);
			}
			
			System.out.println(list.get(i));
		}
		
		Future<Integer> future = bolt.executorService.submit(bolt);
		
		try {
			System.out.println(future.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Integer call() throws Exception {
		// TODO Auto-generated method stub
		return 1234;
	}
}
