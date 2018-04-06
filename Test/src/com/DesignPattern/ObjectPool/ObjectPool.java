package com.DesignPattern.ObjectPool;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


abstract class Pool<T> {
	
	
	Queue<T> queue = new PriorityQueue<T>();
	ScheduledExecutorService scheduledExecutorService;
	
	abstract T createObject();
	
	T getObjectFromQueue(){
		synchronized (this) {
			return queue.poll();	
		}
	}
	
	void addObjectToQueue(T obj){
		synchronized (this) {
			queue.add(obj);	
		}
	}
	
	public Pool(int size) {
		initialize(size);
	}
	
	private void initialize(int size){
		synchronized (this) {
			for(int i=0;i<size;i++){
				queue.add(createObject());
			}	
		}
	}
	
	public void ensurePoolSize(int min, int max, T obj){
		
		scheduledExecutorService.schedule(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
		}, 60, TimeUnit.SECONDS);
	}
}




public class ObjectPool extends Pool<String>{
	
	public ObjectPool(int size) {
		super(size);
	}

	public static void main(String[] args){
		
	}

	@Override
	String createObject() {
		// TODO Auto-generated method stub
		return null;
	}
}
