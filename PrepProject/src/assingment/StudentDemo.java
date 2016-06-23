package assingment;

class A
{
	protected int i=4;
	A(){
		
	}
}

class B extends A{
	protected int i=5;
	
}

public class StudentDemo extends B{
	
	public static void main(String[] args)
	{
		StudentDemo std = new StudentDemo();
		std.testProtected(std);
		Student st1= new Student(1,"vipul",50.0);
		Student st2= new Student(1,"vipul",50.0);
	}
	
	private void testProtected(StudentDemo st)
	{
		System.out.println(i+st.i);
	}

}
