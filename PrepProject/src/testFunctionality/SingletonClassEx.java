package testFunctionality;

abstract class Person
{
	abstract void eat();
}


public class SingletonClassEx {
	
	public static void main(String[] args)
	{
	Person per = new Person()
			{

				@Override
				void eat() {
					System.out.println("Eating raseelay soya chap.");
				}
			};
			
			per.eat();
			
			main(new String[3],3);
	}
	
	public static void main(String[] args, int a)
	{
		System.out.println("New Main method :"+a);
	}
	
	public static void main(String a, String b)
	{
		System.out.println("Output A: "+a+" Output B: "+b);
	}
}
