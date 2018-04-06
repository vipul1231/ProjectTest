package com.generics;

public class GenericPrint implements Runnable{
    
    private <E> void print(E[] array){
	
	for(E e : array){
	    System.out.println(e);
	}
    }
     
    public static void main(String[] args)
    {
	GenericPrint gp = new GenericPrint();
	Thread th1 = new Thread(gp);
	th1.start();
    }

    @Override
    public void run() {
	// TODO Auto-generated method stub
	Integer[] array1 = {1,2,3};
	String[] array2 = {"Vipul","Ankita"};
	print(array1);
	print(array2);
	
    }
}
