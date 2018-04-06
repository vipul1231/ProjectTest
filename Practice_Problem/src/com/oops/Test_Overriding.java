package com.oops;

class A{
   
    Number method1()
    {
	System.out.println("From Base method");
	return 0;
    }   
}

public class Test_Overriding extends A{
    
    Integer method1()
    {
	super.method1();
	System.out.println("From Derived Class");
	return 0;
    }
    
    
    public static void main(String[] args)
    {
	Test_Overriding test_Overriding = new Test_Overriding();
	test_Overriding.method1();
    }

}
