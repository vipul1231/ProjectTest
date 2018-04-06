package com.DesignPattern.ProducerConsumer;

public class Consumer implements Runnable{
	
	Processor processor;
	
	public Consumer(Processor processor){
		this.processor = processor;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			System.out.println("Consummed Object : "+processor.removeObjectsFromList());
		}
	}
}
