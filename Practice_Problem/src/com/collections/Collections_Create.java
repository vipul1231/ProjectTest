package com.collections;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Collections_Create implements Runnable{
    
    Map<Integer,String> map = new ConcurrentHashMap<>();
    
    volatile int value = 100;
     
    public static void main(String[] args)
    {
	Collections_Create collections_Create = new Collections_Create();
	Thread thread1 = new Thread(collections_Create);
	Thread thread2 = new Thread(collections_Create);
	thread1.setName("Thread 1");
	thread2.setName("Thread 2");
	thread1.start();
	thread2.start();
    }

    @Override
    public void run() {
	// TODO Auto-generated method stub
	if(Thread.currentThread().getName().equals("Thread 1")){
	    System.out.println("Inside Thread 1");
	    while(value !=200){
		 addValueToMap();  
	    }    
	}
	
	if(Thread.currentThread().getName().equals("Thread 2")){
	   while(value !=200){
	       readValueFromMap(value);
	   }
	}
    }
    
    void addValueToMap(){
	map.put(value, "Test");
	value++;
    }
    
    void readValueFromMap(Integer value){
	Set<Integer> keys = map.keySet();
	for(Integer key : keys)
	{
	    System.out.println("Key: "+key+" Value: "+map.get(key));
	}
    }
}
