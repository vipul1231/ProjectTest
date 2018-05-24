package com.src;

class X {
public void display()
{
	int i,j,n=8,m=0;
	for(i=1;i<=9;i++)
	{
		for(j=1;j<=n;j++)
		{
			System.out.print(" ");
		}
		if(i<=4)
		{
			n=n-2;
		}
		else{
			n=n+2;
		}
		for(int k=1;k<=2*m+1;k++)
		{
			System.out.print("* ");
		}
		if(i<=4)
		{
			m++;
		}
		else{
			m--;
		}
		System.out.println("");
	}
}
}
public class Y {
	
	
	public static void main(String ar[])
	{
		X x=new X();
		x.display();
	}
}
