package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class CardGame implements Callable<String>{
    
    double nStrength;
    
    
    public static void main(String[] args) {
	
	CardGame cardGame = new CardGame();
	Scanner scanner = new Scanner(System.in);
	
	List<Double> aStrength = cardGame.getData(new ArrayList<>(), scanner); 
	List<Double> bStrength = cardGame.getData(new ArrayList<>(), scanner);
	
	cardGame.findMinimum(aStrength, bStrength);
	scanner.close();
    }
    
    private void findMinimum(List<Double> a, List<Double> b) {
	nStrength = nStrength +1;
	double count =0;
	for(double input : a) {
	    
	    if(input >= nStrength) {
		continue;
	    }
	    	
	    else if(input < nStrength) {
		count  = count + ( nStrength - input);
	    }
	}
	
	System.out.println((int)count);
    }
    
    
    private List<Double> getData(List<Double> input, Scanner scanner) {
	
	nStrength = 0;
	double aNumber  = scanner.nextDouble();
	
	for(int i=0;i<aNumber;i++) {
	    double strength  = scanner.nextInt();
	    if(strength > nStrength) {
		nStrength = strength;
	    }
	    input.add(strength);
	}
	return input;
    }

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}

