package programs;

import java.util.Scanner;

class Test1{
	public void display(){
		String str,str1,str2="";
		int c=0,len=0;
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the two strings");
		str=s.next();
		str1=s.next();
		int l=str.length();
		int l1=str1.length();
		for(int i=0;i<l;i++)
		{
			int x=i;
			while(x<=l)
			{
				String st=str.substring(i,x);
				for(int j=0;j<l1;j++)
				{
					int y=j;
					while(y<=l1)
					{
						String stt=str1.substring(j,y);
						if(st.equals(stt))
						{
							len=st.length();
							if(len>c)
							{	
								c=len;
								str2=st;
							}
						}
						y++;
					}
				
				}
				x++;
			}
		}
		System.out.println(c+"("+str2+")");
		s.close();
	}
}
public class Str {

	public static void main(String[] args) {
		Test1 t=new Test1();
		t.display();

	}

}
