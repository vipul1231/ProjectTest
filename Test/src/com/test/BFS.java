package com.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;


/**
 * This class gives Algorithms for tree traversals technique. 
 * 
 * @author vtiwari
 *
 */
public class BFS {

	List<Node> nodeList  = new ArrayList<>();
	
	final class Node {
		int data;
		int count;
		
		Node leftSubTree;
		Node rightSubTree;
		Node connectNextNode;
		int hd;
		
		public void setCount(int count) {
			this.count = count;
		}
		
		Node(int data, int count){
			this.data = data;
			this.count = count;
			leftSubTree = rightSubTree =  null;
		}
		
	}

	Node start = null;
	private void createBst(Scanner scanner) {
	
		System.out.println("Enter the number limit: ");
		int a = scanner.nextInt();
		
		for(int i=0;i<a;i++) {
			int number = scanner.nextInt();
			if(start == null) {
				//System.out.println("Number: "+number);
				Node node = new Node(number,1);
				start = node;
			}
			else {
				Node begin = start;
				//System.out.println("Number: "+number);
				while(true) {
					
					if(number > begin.data) {
						
						if(begin.rightSubTree != null) {
							begin = begin.rightSubTree;	
						}
						else {
							Node node = new Node(number, 1);
							begin.rightSubTree = node;
							break;
						}
					}
					else if(number < begin.data) {
						
						if(begin.leftSubTree != null) {
							begin = begin.leftSubTree;
						}
						else {
							Node node = new Node(number, 1);
							begin.leftSubTree = node;
							break;
						}	
					}
					else {
						begin.count++;
						break;
					}
				}
			}
		}
		scanner.close();
	}
	
	/**
	 * This traverse BST in Inorder style.
	 * 
	 * @param begin
	 */
	private void traverseBstInOrder(Node begin) {
		
		if(begin == null) {
			return;
		}
		
		traverseBstInOrder(begin.leftSubTree);
		System.out.print (begin.data+" ");
		traverseBstInOrder(begin.rightSubTree);
	}
	
	/**
	 * This method will return height of a tree.
	 * 
	 * @param begin
	 * @return
	 */
	private int computeHeightOfTree(Node begin) {
		if(begin == null) {
			return 0;
		}
		
		int lHeight = computeHeightOfTree(begin.leftSubTree);
		int rHeight = computeHeightOfTree(begin.rightSubTree);
		
		if(lHeight>rHeight) {
			return lHeight+1;
		}
		else {
			return rHeight+1;
		}
	}
	
	/**
	 * Level order traversal.
	 * 
	 * @param begin
	 * @param level
	 */
	private void levelOrderTraversal(Node begin, int level) {
		//System.out.println("Method call: "+begin);
		if(begin == null) {
			return;
		}
		if(level == 1) {
			System.out.print(begin.data+" ");
		}
		else if(level > 1) {
			levelOrderTraversal(begin.leftSubTree, level - 1);
			levelOrderTraversal(begin.rightSubTree,level - 1);
		}
	}
	
	/**
	 * Connect Next Node
	 * 
	 * @param begin
	 * @param level
	 */
	private void connectNextNode(Node begin,int level) {
		 
		if(begin == null) {
			return;
		}
		
		if(level == 1) {
			nodeList.add(begin);
		}
		
		connectNextNode(begin.leftSubTree, level -1);
		connectNextNode(begin.rightSubTree, level -1);
	}
	
	/**
	 * Connect to Node.
	 */
	private void connectNodes() {
		
		for(int i=0;i<nodeList.size();i++) {
			Node node = nodeList.get(i);
			if((i+1) >= nodeList.size()) {
				node.connectNextNode = null;
				return;
			}
			Node next = nodeList.get(i+1);
			node.connectNextNode = next;
		}
	}
	
	/**
	 * Traverse left sub tree
	 * 
	 * @param begin
	 */
	
	int max_level =0;
	
	/**
	 * Left view of tree
	 * 
	 * @param begin
	 * @param level
	 */
	private void leftViewOfBinaryTree(Node begin, int level) {
		
		if(begin == null) {
			return;
		}
		
		if(max_level < level) {
			System.out.println(begin.data+" ");
			max_level = level;
		}
		
		leftViewOfBinaryTree(begin.leftSubTree, level+1);
		leftViewOfBinaryTree(begin.rightSubTree, level+1);
	}
	
	/**
	 * This function traverse right most view of tree
	 * 
	 * @param begin
	 * @param level
	 */
	private void rightViewOfBinaryTree(Node begin, int level) {
		
		if(begin == null) {
			return;
		}
		
		if(max_level < level) {
			System.out.println(" "+begin.data);
			max_level = level;
		}
		
		rightViewOfBinaryTree(begin.rightSubTree, level+1);
		rightViewOfBinaryTree(begin.leftSubTree, level+1);
		
	}
	
	/**
	 * Top view of binary tree.
	 * 
	 * @param begin
	 * @param level
	 */
	List<Integer> processHds = new ArrayList<>();
	LinkedList<Integer> data = new LinkedList<>();
	private void topViewOfBinaryTree(Node begin, int hd) {
		
		if(begin == null){
			return;
		}
		
		else if (!processHds.contains(hd)) {
			if(hd<0){
				data.addFirst(begin.data);
			}
			else{
				data.addLast(begin.data);
			}
			processHds.add(hd);
		
		}
		
		topViewOfBinaryTree(begin.leftSubTree, hd-1);
		topViewOfBinaryTree(begin.rightSubTree, hd+1);
	}
	
	class Values{
		int min, max;
	}
	Values val = new Values();
	
	/**
	 * This function will calculate min and max horizontal distance
	 * 
	 * @param node
	 * @param min
	 * @param max
	 * @param hd
	 */
	private void calculateHdFromRoot(Node node, Values min, Values max, int hd){
		
		if(node == null){
			return;
		}
		
		else if(hd < min.min){
			min.min = hd;
		}
		
		else if(hd > max.max){
			max.max = hd;
		}
		
		calculateHdFromRoot(node.leftSubTree, min, max, hd-1);
		calculateHdFromRoot(node.rightSubTree, min, max, hd+1);
	}
	
	/**
	 * Print the vertical of node
	 * 
	 * @param node
	 * @param line_no
	 * @param hd
	 */
	private void printVertical(Node node, int line_no,int hd){
		
		if(node == null){
			return;
		}
		
		if(line_no==hd){
			System.out.println(node.data);
		}
		
		printVertical(node.leftSubTree, line_no, hd-1);
		printVertical(node.rightSubTree, line_no, hd+1);
	}
	
	/**
	 * This method will print vertical from order traversal.
	 * @param node
	 */
	private void verticalOrderTraversal(Node node){
		calculateHdFromRoot(node, val, val, 0);
		System.out.println("Min: "+val.min+" Max: "+val.max);
		
		for(int i=val.min;i<=val.max;i++)
		{
			printVertical(node, i, 0);
			System.out.println("");
		}
	}
	
	/**
	 * This method will print relative path.
	 * 
	 * @param node
	 */
	Node[] array = new Node[1000];
	private void printRelativePath(Node node, int hd, int len){
		
		if(node == null){
			return;
		}
		else {
			node.hd = hd;
			array[len] = node;
			len++;
		}
		
		if(node.leftSubTree == null && node.rightSubTree == null){
			//We got the leaf node
			printPath(len);
		}
		
		printRelativePath(node.leftSubTree, hd-1, len);
		printRelativePath(node.rightSubTree, hd+1, len);
	}
	
	/**
	 * Print the relative path
	 */
	void printPath(int len){
		System.out.println("\nPrinting relative path....");
		int size = len;
		System.out.println("Printing for leaf node: "+array[len-1].data+"");
		int minHd = findMinHd(len);
		for(int i=size-1;i>=0;i--){
			Node node = array[i];
			int result  = node.hd-minHd;
			
			for(int j=0;j<result;j++){
				System.out.print("-");
			}
			System.out.print(node.data);
			System.out.println();
		}
		System.out.println("");
	}
	
	/**
	 * Find minimum HD in given nodeStack arraylist.
	 * 
	 * @return
	 */
	private int findMinHd(int len){
		int min =0;
		for(int i=0;i<len;i++){
			if(array[i].hd < min){
				min = array[i].hd; 
			}
		}
		
		return min;
	}
	
	/**
	 * Print leaf node path.
	 * 
	 * @param node
	 * @param number
	 */
	private void printLeafNodePath(Node node, int arr[], int len){
		
		if(node == null){
			return;
		}else {
			arr[len] = node.data;
			len++;
		}
		
		if(node.leftSubTree==null && node.rightSubTree == null) {
				for(int i=0;i < len; i++){
					System.out.print(arr[i] + " ");
				}	
			
		}
		else {
			printLeafNodePath(node.leftSubTree, arr, len);
			printLeafNodePath(node.rightSubTree, arr, len);	
		}
	}
	
	/**
	 * This method traverse tree in pre order traversal
	 * 
	 * @param node
	 */
	private void preOrderTraversal(Node node){
		if(node == null){
			return;
		}
		
		System.out.print(node.data+" ");
		preOrderTraversal(node.leftSubTree);
		preOrderTraversal(node.rightSubTree);
	}
	
	/**
	 * This method traverse tree in post order traversal
	 * 
	 * @param node
	 */
	private void postOrderTraversal(Node node){
		if(node == null){
			return;
		}
		
		postOrderTraversal(node.leftSubTree);
		postOrderTraversal(node.rightSubTree);
		System.out.print(node.data+" ");
	}
	
	/**
	 * Traverse tree in spiral order. Recursive approach.
	 * 
	 * @param node
	 */
	private void traverseTreeInSpiralOrderR(Node node, int level, boolean left, boolean right){
	
		if(node == null){
			return;
		}
		
		if(level == 1){
			System.out.print(node.data+" ");
		}
		
		if(level > 1 && left){
			traverseTreeInSpiralOrderR(node.leftSubTree, level-1, left, right);
			traverseTreeInSpiralOrderR(node.rightSubTree, level-1, left, right);
		}
		
		else if(level > 1 && right){
			traverseTreeInSpiralOrderR(node.rightSubTree, level-1, left, right);
			traverseTreeInSpiralOrderR(node.leftSubTree, level-1, left, right);
		}
	}
	
	/**
	 * This method traverse tree in spiral order. Iterative approach.
	 * Complexity time: O(n2) 
	 * Space Complexity: 2*Max Leaf Nodes
	 * 
	 * @param node
	 * @param level
	 */
	Stack<Node> stackOdd = new Stack<>();
	Stack<Node> stackEven = new Stack<>();
	private void traverseTreeInSprialOrderI(Node node, int level, int maxlevel){
		stackOdd.push(node);
		while(level!=maxlevel+1){
			
			if(level%2 == 1){
				int size = stackOdd.size();
				for(int i=0;i < size;i++){
					Node node1 = stackOdd.pop();
					System.out.print(node1.data+" ");
					if(node1.leftSubTree!=null){
						stackEven.push(node1.leftSubTree);
					}
					if(node1.rightSubTree != null){
						stackEven.push(node1.rightSubTree);
					}
				}
				System.out.println();
				level++;
			}
			
			else if(level%2 == 0){
				int size = stackEven.size();
				for(int i=0;i < size;i++){
					Node node1 = stackEven.pop();
					System.out.print(node1.data+" ");
					if(node1.rightSubTree != null){
						stackOdd.push(node1.rightSubTree);
					}
					if(node1.leftSubTree != null){
						stackOdd.push(node1.leftSubTree);
					}
				}
				System.out.println();
				level++;
			}			
		}
	}
	
	/**
	 * This method prints no of leaf nodes of binary tree.
	 * 
	 * @param node
	 */
	private int countLeafNodesOfBinaryTree(Node node){
		
		if(node == null){
			return 0;
		}
		else if(node.leftSubTree==null && node.rightSubTree==null){
			 return 1;
		}
		else {
			return countLeafNodesOfBinaryTree(node.leftSubTree) + countLeafNodesOfBinaryTree(node.rightSubTree);
		}
	}
	
	
	
	/**
	 * Main App
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BFS obj = new BFS();
		obj.createBst(scanner);
		
		System.out.println("Inorder traversal.......");
		obj.traverseBstInOrder(obj.start);
		System.out.println();
		int data = obj.computeHeightOfTree(obj.start);
		
		System.out.println("Tree Height: "+data);
		
		System.out.println("Level order traversal.......");
		
		for(int i=1;i<=data;i++) {
			obj.levelOrderTraversal(obj.start, i);
			System.out.println();
		}
		
		System.out.println("<----------End----------->");
		System.out.println();
		
		System.out.println("Connect Next Node.......");
		for(int i=1;i<=data;i++) {
			obj.connectNextNode(obj.start, i);
			obj.connectNodes();
			obj.nodeList.clear();
		}
		System.out.println("<----------End----------->");
		System.out.println();
		
		System.out.println("Left view of Binary tree........");
		obj.leftViewOfBinaryTree(obj.start, 1);
		System.out.println("<----------End----------->");
		System.out.println();
		obj.max_level = 0;
		
		System.out.println("Right view of Binary tree........");
		obj.rightViewOfBinaryTree(obj.start, 1);
		System.out.println("<----------End----------->");
		System.out.println();
		
		System.out.println();
		System.out.println("<----------End----------->");
		
		System.out.println("Relative path of node");
		//obj.printRelativePath(obj.start);
		obj.verticalOrderTraversal(obj.start);

		//TODO: this implementation is wrong. Fix this.
		System.out.println("Top view of Binary tree........");
		obj.topViewOfBinaryTree(obj.start, 0);
		
		for(Integer integer : obj.data){
			System.out.print(integer+" ");
		}
		
		System.out.println("Print relative path.........");
		obj.printRelativePath(obj.start, 0, 0);
		obj.printLeafNodePath(obj.start, new int[100],0);
		
		System.out.println("\nPre-order traversal.........");
		obj.preOrderTraversal(obj.start);
		
		System.out.println("\nPost-order traversal.........");
		obj.postOrderTraversal(obj.start);
		
		System.out.println("\nTraverse tree in spiral order in recursive approach....");
		
		for(int i=1;i<data+1;i++){
			if(i==1){
				obj.traverseTreeInSpiralOrderR(obj.start, i, false, false);	
			}
			else if(i%2==0){
				obj.traverseTreeInSpiralOrderR(obj.start, i, false, true);
			}
			else {
				obj.traverseTreeInSpiralOrderR(obj.start, i, true, false);
			}	
		}
		
		System.out.println("\n Travese tree in sprial order iterative approach....");
		obj.traverseTreeInSprialOrderI(obj.start, 1, data);
		
		System.out.println("\nCount no of leaf nodes in a tree.....");
		System.out.println(obj.countLeafNodesOfBinaryTree(obj.start));
	}
}
