package programs;

import java.util.*;


class B
{
    public void display()
    {
        Scanner s= new Scanner(System.in);
        int i=0;
       do
       {
           System.out.println("Enter the number");
            i=s.nextInt();
            switch(i)
            {
                case 1: System.out.println("Sunday");
                        break;
                case 2: System.out.println("Monday");
                        break;
                case 3: System.out.println("Tuesday");
                        break;
                case 4: System.out.println("Wednesday");
                        break;
                case 5: System.out.println("Thursday");
                        break;
                case 6: System.out.println("Friday");
                        break;
                case 7: System.out.println("Saturday");
                        break;
                case -999: System.exit(0);
                default: System.out.println("Invalid entry");
            }
       }while(i!=-999);
    }
}
class Test
{
	public static void main(String[] args) 
	{
		B b=new B();
		b.display();
	}
}
