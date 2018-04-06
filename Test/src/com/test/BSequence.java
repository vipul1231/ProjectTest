package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * This class calculate B Sequence
 * 
 * @author vtiwari
 *
 * TODO: modfiy this algo to process records in 2 sec
 */
public class BSequence{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();
		Map<Integer, Integer[]> countMap = new HashMap<>();
		long start= System.currentTimeMillis();
		int nt = scanner.nextInt();
		
		int max = 0;
		int maxIndex = 0;
		for(int i=0;i<nt;i++){
			int number = scanner.nextInt();
			if(number > max){
				max = number;
				maxIndex = i;
			}
			list.add(number);
			
			Integer[] count = countMap.get(number);
			if(count == null){
				Integer[] array = new Integer[2];
				array[0] = 1;
				array[1] = i;
				countMap.put(number, array);
			}
			else {
				count[0] = ++count[0];
				count[1] = i;
				countMap.put(number, count);
			}
		}
		
		int operation = scanner.nextInt();
		//Check for operations.
		for(int i=0;i<operation;i++){
			int number = scanner.nextInt();
			int size  = list.size();
			if(number == max){
				System.out.println(size);
			}
			
			else if(number > max){
				//This is new max number.
				maxIndex += 1;
				list.add(maxIndex, number);
				System.out.println(size +1);
				countMap.put(number,new Integer[]{1,maxIndex});
				max = number;
			}
			
			else {
				Integer[] count  = countMap.get(number);
				if(count == null){
					int counter = 0;
					
					if(number < list.get(0)){
						list.add(0, number);
						countMap.put(number, new Integer[]{1,0});
						maxIndex +=1;
						System.out.println(size+1);
						continue;
					}
					
					while(counter != maxIndex){
						int n1 = list.get(counter);
						int n2 = list.get(counter + 1);
						if(n1 < number && number < n2){
							list.add(counter+1, number);
							countMap.put(number, new Integer[]{1,counter});
							maxIndex +=1;
							System.out.println(size+1);
							break;
						}
						counter++;
					}
						
				}
				
				else if(count[0] == 2){
					System.out.println(size);
				}
				else if (count[0] == 1) {
					// Now we have to insert number.

					int counter = maxIndex;

					if (list.get(size - 1) > number) {
						list.add(size, number);
						countMap.put(number, new Integer[] { 2, 2 });
						System.out.println(size+1);
						continue;
					}

					while (counter != (size - 1)) {
						int n1 = list.get(counter);
						int n2 = list.get(counter + 1);
						if (n1 > number && number > n2) {
							list.add(counter + 1, number);
							System.out.println(size+1);
							countMap.put(number, new Integer[] { 2, 2 });
							break;
						}
						counter++;
					}

				}
			}
		}
		
		System.out.println(list.toString().replace(",", "").replace("[", "").replace("]", ""));
		long end = System.currentTimeMillis();
	
		System.out.println("\nTime Taken: "+String.format("%dSec", ((end-start)/1000)%60));
		scanner.close();
	}
	
	
	
}
