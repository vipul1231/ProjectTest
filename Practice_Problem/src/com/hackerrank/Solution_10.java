package com.hackerrank;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Finding favorite Subsequence
 * 
 * @author Vipul_Anky
 *
 */
public class Solution_10 {
    
    class CharInfo {

	    char character;
	    List<Integer> occurance = new ArrayList<>();

	    public char getCharacter() {
		return character;
	    }

	    public void setCharacter(char character) {
		this.character = character;
	    }

	    public List<Integer> getOccurance() {
		return occurance;
	    }

	    public void setOccurance(List<Integer> occurance) {
		this.occurance = occurance;
	    }
	}

    Map<String, CharInfo> mapOfCharacters = new HashMap<>();

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Solution_10 solution_10 = new Solution_10();
	long startTime = System.currentTimeMillis();
	String input = null;
	try {
	    BufferedReader reader = new BufferedReader(new FileReader("..\\Practice_Problem\\src\\com\\hackerrank\\test2.txt"));
	    input = reader.readLine();
	    System.out.println(input.length());
	    solution_10.findUniqueLettersInString(input);
	    reader.close();
	} catch (FileNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	
	solution_10.findPossibleCombination(solution_10.findTheSubsequence());
	long endTime   = System.currentTimeMillis();
	NumberFormat formatter = new DecimalFormat("#0.00000");
	System.out.print("Execution time is " + formatter.format((endTime - startTime) / 1000d) + " seconds");
	
	//scanner.close();
    }

    private void findUniqueLettersInString(String input) {
	char[] charArray = input.toCharArray();
	for (int i = 0; i < charArray.length; i++) {
	    CharInfo charInfo = mapOfCharacters.get(String.valueOf(charArray[i]));
	    if (charInfo == null) {
		CharInfo charObject = new CharInfo();
		charObject.setCharacter(charArray[i]);
		charObject.getOccurance().add(i);
		mapOfCharacters.put(String.valueOf(charArray[i]), charObject);
	    } else {
		charInfo.getOccurance().add(i);
	    }
	}
    }

    /**
     * 
     * 
     * @return
     */
    private List<List<List<Integer>>> findTheSubsequence() {
	List<List<List<Integer>>> list = new ArrayList<>();
	Set<String> keySet = mapOfCharacters.keySet();
	

	// Assign the position to list of list
	for (String string : keySet) {
	    CharInfo charInfo = mapOfCharacters.get(string);
	    list.add(findingSubsets(charInfo.getOccurance()));
	}
	//System.out.println(list);
	 
	return list;
    } 
    
    /**
     * Find the possible combination
     * 
     * @param list
     */
    private void findPossibleCombination(List<List<List<Integer>>> list){
	int i=0;
	List<List<Integer>> possibleCombination = new ArrayList<>();
	List<List<Integer>> combinationCopy = new ArrayList<>();
	boolean firstIteration = false;
	while(i!=list.size()){  
	    List<List<Integer>> firstCombination = list.get(i);
	    int length =0;
	    //Assign the first possible list to possible combination
	    if(possibleCombination.size() == 0){
		firstIteration = true;
		while(length != firstCombination.size()){
		    possibleCombination.add(firstCombination.get(length));
		    length++;
		}
	    }
	    
	    else {
		firstIteration = false;
		combinationCopy.addAll(deepCopyList(possibleCombination));
		while(length!= firstCombination.size()){
		    compareAndAddList(firstCombination.get(length), possibleCombination); 
		    length++;
		}
	    }
	    if(!firstIteration){
		possibleCombination.removeAll(combinationCopy);
	    }
	    i++;
	}
	System.out.println(possibleCombination.size());
    }
    
    /**
     * Deep Copy of possible combination list.
     * 
     * @param list
     * @return
     */
    private List<List<Integer>> deepCopyList(List<List<Integer>> list){
	List<List<Integer>> combinationCopy = new ArrayList<>();
	combinationCopy.addAll(list);
	return combinationCopy;
    }
    
    /**
     * Compare and Add List
     * 
     * @param list
     * @param possibleCombination
     */
    private void compareAndAddList(List<Integer> list, List<List<Integer>> possibleCombination){
	List<List<Integer>> newCombinationList = new ArrayList<>();
	//for(Integer number : list){
	int number = list.get(0);
	    for(List<Integer> pcList : possibleCombination){
		if(pcList.get(pcList.size()-1) < number){
		    List<Integer> newCombo = new ArrayList<>();
		    newCombo.addAll(pcList);
		    newCombo.addAll(list);
		    boolean contains = false;
		    for(List<Integer> ncList : possibleCombination){
			if(ncList.containsAll(newCombo)){
			    contains = true;   
			}
		    }
		    if(!contains){
			newCombinationList.add(newCombo);
		    }
		}
	    }
	//}
	
	possibleCombination.addAll(newCombinationList);
	
    }
    
    /**
     * Find the subsets from the given set
     * 
     * @param array
     */
    private List<List<Integer>> findingSubsets(List<Integer> array) {
	List<List<Integer>> list = new ArrayList<>();
	int n = array.size();
	for (int i = 0; i < (1 << n); i++) {
	    List<Integer> testInteger = new ArrayList<>();
	    for (int j = 0; j < n; j++)
		if ((i & (1 << j)) > 0) {
		    testInteger.add(array.get(j));
		}
	    if(!testInteger.isEmpty()){
		list.add(testInteger);
	    }
	}
	return list;
    }
}