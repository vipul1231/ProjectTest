package com.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ThoughtWorks_NewChallenge {
	
	public static void main(String[] args){
	
		Scanner scanner = new Scanner(System.in);
		int noOfTest = Integer.parseInt(scanner.nextLine());
		for(int i=0;i<noOfTest;i++){
			
			String[] input = scanner.nextLine().split(" ");
			int downloadSpeed = Integer.parseInt(input[1]);
			List<Double> list = Arrays.asList(scanner.nextLine().split(" ")).stream().map(Double::parseDouble).collect(Collectors.toList());
			Collections.sort(list);
			int totalTime = 0;
			Double subtractedValue = 0d;
			for(int k=0;k<list.size();k++){
			
				double speedPerFile = Math.floor(downloadSpeed / (list.size() - k));
				double fileSize = list.get(k);
				
				if(subtractedValue > 0){
					fileSize -= subtractedValue;
					subtractedValue +=fileSize;
				}
				
				double timeTaken = fileSize/speedPerFile;
				double value  = Math.ceil(timeTaken);
				totalTime +=value;
				
				if(k==0){
					subtractedValue = fileSize;	
				}
				
				while(true){
					if((k+1) < list.size() && list.get(k).equals(list.get(k+1))){
						k++;
						continue;
					}
					else {
						break;
					}
				}
			}
			
			System.out.println(totalTime);
		}
		scanner.close();
	}
}
