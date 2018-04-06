package com.src;

class P{
	public void display(){
		int i,n=4,m=1;
		for(i=1;i<=5;i++)
		{
			for(int j=1;j<=n;j++)
			{
				System.out.print(" ");
			}
			n=n-1;
			for(int k=1;k<=m;k++)
			{
				System.out.print("* ");
			}
			m++;
			System.out.println("");
		}
	}
}
public class Pattern {
	public static void main(String a[])
	{
		P p=new P();
		p.display();
	}

}
