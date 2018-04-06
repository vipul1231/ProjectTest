package programs;

import java.util.Scanner;

class C
{
    public void display()
    {
        int i,n=1,current=1, previous=1;
        Scanner s= new Scanner(System.in);
        System.out.println("Enter the number you want to print");
        i=s.nextInt();
        System.out.println("Fibonacci series is");
        System.out.println(current);
        System.out.println(previous);
        while(n<i)       
        {
        	int next = current+previous;
        	//1 1  2 1  3 1
        	System.out.println(next);
        	previous++;
        	n++;
        			//1,1,2,3,5,8,13     		
        }
        }
}
public class Fibonacci
{
	public static void main(String[] args) 
	{
		C b=new C();
		b.display();
	}
}

