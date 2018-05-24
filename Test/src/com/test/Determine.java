package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Determine {

	public static void main(String[] args){
	
		Scanner scanner = new Scanner(System.in);
		
		int n = Integer.parseInt(scanner.nextLine());

		for(int i=0;i<n;i++){
			
			String[] questions = scanner.nextLine().split(" ");
			String[] deduction = scanner.nextLine().split(" ");
			String[] flash = scanner.nextLine().split(" ");
			String[] cisco = scanner.nextLine().split(" ");
			
			float p = Float.parseFloat(questions[0]);
			float q = Float.parseFloat(questions[1]);
			float r = Float.parseFloat(questions[2]);
			float s = Float.parseFloat(questions[3]);
			
			float s_p = Float.parseFloat(deduction[0]);
			float s_q = Float.parseFloat(deduction[1]);
			float s_r = Float.parseFloat(deduction[2]);
			float s_s = Float.parseFloat(deduction[3]);
			
			//Flash
			float f_p = Float.parseFloat(flash[0]);
			float f_q = Float.parseFloat(flash[1]);
			float f_r = Float.parseFloat(flash[2]);
			float f_s = Float.parseFloat(flash[3]);
			
			//Cisco
			float c_p = Float.parseFloat(cisco[0]);
			float c_q = Float.parseFloat(cisco[1]);
			float c_r = Float.parseFloat(cisco[2]);
			float c_s = Float.parseFloat(cisco[3]);
			
			List<Float> resultFlash = new ArrayList<>();
			List<Float> resultCisco = new ArrayList<>();
			for(int k=0; k< 4; k++){
				
				float ques = Float.parseFloat(questions[k]);
				float deds = Float.parseFloat(deduction[k]);
				
				float time = Float.parseFloat(questions[k]);
				
				float score =  ((s_p/2) < (ques - (deds*time))) ? (ques - (deds*time)) : (s_p/2)   ;
				resultFlash.add(score);
			}
			
			
			//time taken
			float t1 = p - (f_p * s_p);
			float t2 = q - (f_q * s_q);
			float t3 = r - (f_r * s_r);
			float t4 = s - (f_s * s_s);
			
			t1 = ((s_p/2) < t1) ? t1 : (s_p/2);
			t2 = ((s_q/2) < t2) ? t2 : (s_q/2);
			t3 = ((s_r/2) < t3) ? t3 : (s_r/2);
			t4 = ((s_s/2) < t4) ? t4 : (s_s/2);
			
			float[] array1 = new float[4];
			array1[0] = f_p;
			array1[1] = f_q;
			array1[2] = f_r;
			array1[3] = f_s;
			
			
			float t11 = p - (c_p * s_p);
			float t22 = q - (c_q * s_q);
			float t33 = r - (c_r * s_r);
			float t44 = s - (c_s * s_s);
			
			t11 = ((s_p/2) < t11) ? t11 : (s_p/2);
			t22 = ((s_q/2) < t22) ? t22 : (s_q/2);
			t33 = ((s_r/2) < t33) ? t33 : (s_r/2);
			t44 = ((s_s/2) < t44) ? t44 : (s_s/2);
			
			float[] array2 = new float[4];
			array2[0] = c_p;
			array2[1] = c_q;
			array2[2] = c_r;
			array2[3] = c_s;
			
			float totalScoreT = t1+t2+t3+t4;
			float totalScoreTT = t11+t22+t33+t44;
			
			if(totalScoreT > totalScoreTT){
				System.out.println("Flash");
			}
			else if(totalScoreT < totalScoreTT){
				System.out.println("Cisco");
			}
			else {
				Arrays.parallelSort(array1);
				Arrays.parallelSort(array2);
				
				if(array1[3] > array2[3]){
					System.out.println("Cisco");
				}
				else if(array1[3] < array2[3]){
					System.out.println("Flash");
				}
				else {
					System.out.println("Tie");
				}
			}
			
		}
		
		scanner.close();
	}
}
