package com.hackerrank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


/**
 * Sphere problem where it takes 4 input
 * 
 * Line 1: no of testcases
 * Line 2: length of Lines 3 or 4 etc, No of spheres on Rope
 * Line 3: Position of spheres 
 * 
 * Ex:
 * 
 * 2 (No of Testcases)
 * 4 2 (length of rope, No of Spheres)
 * 2 4 ( 2 and 4 are the position of sphere)
 * 
 * @author Vipul_Anky
 *
 */
public class Solution_7 {

    
    public final Long SPHERE_VALUE = Long.valueOf(17);
    
    public static final String DIRECTION_LEFT = "LEFT";
    
    public static final String DIRECTION_RIGHT = "RIGHT";
    
    public static void main(String[] args) {

	Solution_7 obj = new Solution_7();
	Scanner s = new Scanner(System.in);
        int noOfTestCases = Integer.parseInt(s.nextLine());
        int lengthOfRope = 0,noOfSpheres = 0;
        
        for(int i=0;i<noOfTestCases;i++){
            String[] cases = s.nextLine().split(" ");
            lengthOfRope= Integer.parseInt(cases[0]);
            noOfSpheres = Integer.parseInt(cases[1]);
            if(noOfSpheres != 0){
        	String line = s.nextLine();
                String[] positionOfSphere =  line.split(" "); 
                obj.findTimeInSphereMovement(lengthOfRope, positionOfSphere);
            }
        }
                
        s.close();
    }
    
    
    public void findTimeInSphereMovement(int lengthOfRope, String[] positionOfSphere){
	List<Long> ropeArray = new ArrayList<>(lengthOfRope);
	List<Integer> time = new ArrayList<>();
	int count =0;
	
	for(int i=0;i<lengthOfRope;i++){
	    if(Integer.parseInt(positionOfSphere[count]) == i){
		ropeArray.add(SPHERE_VALUE);
		count++;
	    }
	    else{
		ropeArray.add(null);
	    }
	    
	}
	
	time.add(timeForSphereToMoveOut(ropeArray, DIRECTION_LEFT));
	time.add(timeForSphereToMoveOut(ropeArray, DIRECTION_RIGHT));
	time.add(timeForSphereToMoveOut(ropeArray, "LEFT:RIGHT"));
	time.add(timeForSphereToMoveOut(ropeArray, "RIGHT:LEFT"));
	
	Collections.sort(time);
	
	System.out.println(time.get(0)+" "+time.get(time.size()-1));
	
    }
    
    
    public int timeForSphereToMoveOut(List<Long> ropeList, String direction){
	
	if(direction.equals(DIRECTION_LEFT)){
	    int value = ropeList.lastIndexOf(SPHERE_VALUE);
	    return value;
	}
	
	else if(direction.equals(DIRECTION_RIGHT)){
	    int value = ropeList.indexOf(SPHERE_VALUE);
	    return ropeList.size() - value;
	}
	
	String[] dualDirection = direction.split(":");
	
	if(dualDirection[0].equals(DIRECTION_LEFT) && dualDirection[1].equals(DIRECTION_RIGHT)){
	    int leftValue = ropeList.indexOf(SPHERE_VALUE);
	    int rightValue = ropeList.lastIndexOf(SPHERE_VALUE) - (ropeList.size()-1);
	    if(leftValue>rightValue){
		return leftValue;
	    }
	    else if(leftValue<rightValue){
		return rightValue;
	    }
	}
	
	//DIRECTION_RIGHT
	
	else if(dualDirection[0].equals(DIRECTION_RIGHT) && dualDirection[1].equals(DIRECTION_LEFT)){
	    return 2;
	}
	

	return 0;
    }
}
