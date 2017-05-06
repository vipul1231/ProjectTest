package test.OopsConcepts;

import test.AccessModifiers.ProtectedAccessModifiers;

class A extends ProtectedAccessModifiers{
    
    A(){
	
    }
    
    void test(){
	System.out.println(sumOfNumber());
    }
    
}

public class TestOverriding extends A{
    
    @Override
    protected void test() throws RuntimeException{
	   super.test();
    }
   
    public static void main(String[] args){
	TestOverriding object = new TestOverriding();
	object.test();	
    }
}
