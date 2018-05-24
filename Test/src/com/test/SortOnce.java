package com.test;

public class SortOnce {
	
	int[] array= {3, 1, 1, 3, 1, 2, 1, 2, 3, 3, 3, 1};
	
	
	public static void main(String[] args){
		SortOnce sort = new SortOnce();
		sort.sortTheArray();
	}
	
	
	private void sortTheArray(){
		
		for(int i=0;i<array.length;i++){
			
			if( i==0 ){
				int count = 0;
				int one = 0;
				int two = 0;
				int three = 0;
				while(count!=3){
				
					int value = array[count];
					
					switch (value) {
					case 1:
						one++;
						break;
						
					case 2:
						two++;
						break;

					case 3 :
						three++;
						break;
					}
					count++;
				}
				
				for(int j=0 ;j<one;j++){
					array[j] = 1; 
 				}
				
				for(int j=0 ;j<two;j++){
					array[one+j] = 2; 
 				}
				
				for(int j=0 ;j<three;j++){
					if(two!=0)
					array[two+j] = 3;
					else {
						array[one+j] = 3;
					}
				}
			}
		}
		
		System.out.println("Length: "+array.length);
		for(int k=0;k<array.length;k++){
			System.out.print(array[k]+" ");
		}
	}
}
