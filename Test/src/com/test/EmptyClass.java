package com.test;

public class EmptyClass {
	

	public <E> void printArray(E obj){
		
	}
	
	
	public static void main(String[] args){
		
	
		int[] ticket = {2,6,3,4,5};
		int[] duplicate = new int[ticket.length];
		
		int p = 2;
		
		int counter = 0;
		long count = 0;
		while(ticket[p]!=0){
			
			int value1 = ticket[counter];
			if(value1==0){
				counter++;
				continue;
			}
			ticket[counter] = value1-1;
			
			for(int i=0;i<ticket.length;i++){
				System.out.print(ticket[i]+" ");
			}
			System.out.println("\n");
			
			int value2 =  duplicate[counter];
			duplicate[counter] = value2+1;
			if(counter==ticket.length-1){
				count++;
				counter=0;
				continue;
			}
			
			counter++;
			count++;
		}
		
		System.out.println(count);
		
	}
}
