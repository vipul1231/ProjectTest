package programs;

import java.util.Scanner;

class Ax{
	public void display()
	{
		int a[]=new int[100];
		int n;
		Scanner s=new Scanner(System.in);
		System.out.println("How many numbers you want to enter");
		n=s.nextInt();
		System.out.println("Enter the numbers");
		for(int i=0;i<n;i++){
			a[i]=s.nextInt();
		}
		System.out.println("Palindrome substrings are");
		for(int i=0;i<n;i++)
		{
			for(int j=i;j<n;j++)
			{
				int l=j,f=1;
				for(int y=i;y<=j;y++)
				{
					if(a[y]!=a[l])
					{
						f=0;
						break;
					}
					l--;
				}
				if(f==1)
				{
					if(i==j)
					{	
						int c=1;
						for(int p=0;p<i;p++)
						{
							if(a[p]==a[i])
							{
								c=0;
							}
						}
						if(c==1)
						{
							System.out.println(a[i]);
						}
					}
					else{
					for(int p=i;p<=j;p++)
					{
						System.out.print(a[p]);
					}
					System.out.println("");
					}
				}
					
				
			}
		}
		s.close();	
	}
}
public class Palin {
	public static void main(String arg[])
	{
		Ax ax=new Ax();
		ax.display();
	}
}
