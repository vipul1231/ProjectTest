package com.test;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BinarySwap {
	
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		
		String[] a = scanner.nextLine().split("");
		String[] b = scanner.nextLine().split("");
		
		List<Integer> listA = Arrays.asList(a).stream().map(Integer::parseInt).collect(Collectors.toList());
		List<Integer> listB = Arrays.asList(b).stream().map(Integer::parseInt).collect(Collectors.toList());
		
		int aOne =0, bOne = 0, swaps = 0;
		for(int i=0;i<listA.size();i++){
			if(listA.get(i) == 1){
				aOne++;
			}
			if(listB.get(i) == 1){
				bOne++;
			}	
			
			
			//Conditions
			if(listB.get(i) == 1 && listA.get(i) == 1){
				continue;
			}
			if(listB.get(i) == 0 && listA.get(i) == 1){
				swaps++;
			}
		}
		
		if(aOne!=bOne){
			System.out.println(-1);
		}
		
		else {
			System.out.println(swaps);
		}
		
		
		scanner.close();
	}
}
