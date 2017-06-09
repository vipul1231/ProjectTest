package test.OopsConcepts;

import test.AccessModifiers.ProtectedAccessModifiers;

class A extends ProtectedAccessModifiers{
    
    
    
    /**
     * Example ref
     * 
     * @param i
     */
    public A(int i){
	System.out.println(1);
    }
    
    /**
     * Example ref
     */
    public A(){
	this(10);
	System.out.println(2);
    }
    
    /**
     * Example ref
     */
    void A(){
	this.A(10);
	System.out.println(3);
    }
    
    void A(int i){
	System.out.println(4);
    }
    
    /**
     * Normal Overriding
     */
    void test(){
	System.out.println(sumOfNumber());
    }
    
    /**
     * Static overrding
     */
    static void staticTest(Number a){
	System.out.println("Static parent");
    }
    
    void method1(Number a){
	System.out.println("Number :"+a);
    }
    
}

public class TestOverriding extends A{
    
    @Override
    protected void test() throws RuntimeException{
	   System.out.println("calling parent test");
	   super.test();
    }
    
    static void staticTest(Double a){
	System.out.println("Static base");
    }
    
    void method2(Integer d){
	System.out.println("Double :"+d);
    }
    
    void method2(Number n){
	System.out.println("Number :"+n);
    }
   
    public static void main(String[] args){
	
	TestOverriding object = new TestOverriding();
	object.method2((short) 12);
	//object.test();	
	
	//object.staticTest();
	
	//A a = (A) object;
	//a.staticTest();
	
	new A();
    }
}
