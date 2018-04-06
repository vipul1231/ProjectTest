package com.DesignPattern.ProducerConsumer;

import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable{

	Processor processor;
	
	public Producer(Processor processor) {
		// TODO Auto-generated constructor stub
		this.processor = processor;
	}
	
	public static void main(String[] args){
		Processor processor = new Processor();
		Producer producer = new Producer(processor);
		Consumer consumer = new Consumer(processor);
		
		Thread th1 = new Thread(producer);
		Thread th2 = new Thread(consumer);
		
		th1.start();
		th2.start();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		AtomicInteger atm = new AtomicInteger(0);
		while(true){
			processor.addObjectToList(""+atm.incrementAndGet());
		}
	}
}
