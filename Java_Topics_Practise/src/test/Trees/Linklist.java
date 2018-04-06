package test.Trees;

import java.util.Scanner;

/**
 * LinkList and operations
 * 
 * @author Vipul_Anky
 *
 */
public class Linklist {
    
    Node<Integer> head = null;
    
    
    int insert(int value){
	Node<Integer> start = null;
	if(head == null){
	    Node<Integer> node = new Node<Integer>();
	    node.setData(value);
	    node.setNext(null);
	    head = node;
	}
	
	else {
	    start = head;
	    while(start.getNext() != null){
		start = start.getNext();
	    }
	    
	    Node<Integer> node = new Node<Integer>();
	    node.setData(value);
	    node.setNext(null);
	    start.setNext(node);
	}
	
	return 0;
    }
    
    int delete(int value){
	Node<Integer> start = head.getNext();
	Node<Integer> previous = head;
	
	//Check if value contains first node.
	if(previous.getData() == value){
	    head = start;
	    return 0;
	}
	
	while(start != null){
	    
	    if(value == start.getData()){
		System.out.println("Deleting node :"+value);
		previous.setNext(start.getNext());		
		break;
	    }
	    
	    previous = start;
	    start = start.getNext();
	}
	
	
	return 0;
    }
    
    
    void display(){
	Node<Integer> start = head;
	while(start !=null){
	    System.out.print(start.getData() +" ");
	    start = start.getNext();
	}
    }
    
    int reverse(){
	Node<Integer> current = head;
	Node<Integer> previous = null;
	Node<Integer> next;
	
	while(current != null) {
	    next = current.getNext();
	    current.setNext(previous);
	    previous = current;
	    current = next;
	}
	
	head = previous;
	return 0;
    }
    
    int findMiddle(){
	Node<Integer> x = head;
	Node<Integer> twiceX = head;
	
	while (twiceX != null){
	    x = x.getNext();
	    
	    if(twiceX.getNext()!=null){
		twiceX = twiceX.getNext().getNext();
	    }
	    else {
		twiceX = null;
	    }
	}
	
	System.out.println("Middle element is :"+x.getData());

	return 0;
    }
    
    int swapTheNumbers(int position){
	
	
	
	
	
	return 0;
    }
    
    public static void main(String[] args){
	
	Scanner scanner = new Scanner(System.in);
	Linklist linklist = new Linklist();
	System.out.println("Enter the length of linkList:");
	int length = scanner.nextInt();
	for(int i=0;i<length;i++){
	    System.out.println("Enter the value "+i+" :");
	    linklist.insert(scanner.nextInt());
	}
	
	linklist.display();
	System.out.println("Enter the value to delete :");
	linklist.delete(scanner.nextInt());
	
	linklist.display();
	
	System.out.println("Reversing the linklist: ");
	linklist.reverse();
	linklist.display();
	
	System.out.println("Finding middle of linklist: ");
	linklist.findMiddle();
	
	
	System.out.println("Enter the number you want to swap: ");
	linklist.swapTheNumbers(scanner.nextInt());
	linklist.display();

	scanner.close();
    }

}
