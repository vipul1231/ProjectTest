package test.OopsConcepts;

import test.AccessModifiers.ProtectedAccessModifiers;

interface XZ {
    	void test();
}

class A extends ProtectedAccessModifiers{
    
    void test(){
	System.out.println("test");
    }
    
    static void test1(){
	System.out.println("test1");
    }
    
}

public class TestOverriding extends A{
    
    void test(){
	System.out.println("Base Test");
    }
    
    static void test1(){
	System.out.println("Base test1");
    }
   
    public static void main(String[] args){
	
	A object = new TestOverriding();
	
	object.test();
	object.test1();
	
	TestOverriding.test1();
	A.test1();
	
	System.out.println(new XZ() {
	    
	    public void test() {
		// TODO Auto-generated method stub
		
	    }
	});
	
    }
}
