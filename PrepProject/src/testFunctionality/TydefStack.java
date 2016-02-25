package testFunctionality;

import java.util.Stack;

public class TydefStack<E extends Number> {
	
	private void stackPushImpl(Stack<E> stack, E obj)
	{
		stack.push(obj);
	}
	
	private E stackPollImpl(Stack<E> stack)
	{
		return stack.pop();
	}
	
	public static void main(String[] args)
	{
		TydefStack<Integer> obj  = new TydefStack<>();
		TydefStack<Double> obj1  = new TydefStack<>();
		
		Stack<Integer> st = new Stack<>();
		Stack<Double> st1 = new Stack<>();
		
		obj.stackPushImpl(st, 4);
		obj.stackPushImpl(st, 5);
		obj.stackPushImpl(st, 6);
		obj.stackPushImpl(st, 7);
		obj.stackPushImpl(st, 8);
		
		obj1.stackPushImpl(st1, 4.4);
		System.out.println(obj1.stackPollImpl(st1));
		
		
		System.out.println(obj.stackPollImpl(st));
		System.out.println(obj.stackPollImpl(st));
		System.out.println(obj.stackPollImpl(st));
		System.out.println(obj.stackPollImpl(st));
		System.out.println(obj.stackPollImpl(st));
		
		
	}

}
