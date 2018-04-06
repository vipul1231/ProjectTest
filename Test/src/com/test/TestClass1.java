package com.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class TestClass1 implements Runnable{
	
	Queue<Integer> queue = new LinkedList<>();
	
	private final int LIMIT;
	
	public TestClass1(int limit) {
		this.LIMIT = limit;
	}
	
	
	public synchronized boolean addToQueue(Integer t) throws InterruptedException{
		System.out.println("Adding to Queue: "+t+" "+Thread.currentThread().getName());
		if(queue.size() == LIMIT){
			System.out.println("Queue is full.");
			wait();
		}
		notify();
		return queue.add(t);
	}
	
	public synchronized boolean removeFromQueue() throws InterruptedException{
		if(queue.size() == 0){
			System.out.println("Queue is empty "+Thread.currentThread().getName());
			notify();
			wait();
		}
		Integer number = queue.poll();
		System.out.println("Removing from queue "+number+" "+Thread.currentThread().getName());
		return false;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		if(Thread.currentThread().getName().equals("Producer")){
			while(true){
				Random rand = new Random();
				try {
					addToQueue(rand.nextInt(10));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		else if(Thread.currentThread().getName().equals("Consumer")){
			while(true){
				try {
					removeFromQueue();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static void main(String[] args){
		TestClass1 obj = new TestClass1(10);
		Thread producer = new Thread(obj);
		producer.setName("Producer");
		Thread consumer = new Thread(obj);
		consumer.setName("Consumer");
		producer.start();
		consumer.start();
	}
}
