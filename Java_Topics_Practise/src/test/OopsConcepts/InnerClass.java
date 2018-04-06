package test.OopsConcepts;

import test.OopsConcepts.UpperClass.NestedInnerClass;
import test.OopsConcepts.UpperClass.StaticInnerClass;

class UpperClass {
    
    int a;
    static int b;
    
    class NestedInnerClass{
	
	void setA(int b){
	    a = b;
	}
	
	int getA(){
	    return a;
	}
    }
    
    /**
     * This class have access to only static member of upper class
     * 
     * @author Vipul_Anky
     *
     */
    static class StaticInnerClass {
	
	int getB()
	{
	    //return a; //Throws error
	    return b;
	}
	
	void setB(int c){
	    b = c;
	}
    }
    
    int getAO(){
	return a;
    }
    
    int getBO(){
	return b;
    }
}




public class InnerClass {
    
    public static void main(String[] args){
	UpperClass obj = new UpperClass();
	NestedInnerClass nestedInnerClass = obj.new NestedInnerClass();
	nestedInnerClass.setA(2);
	
	System.out.println(nestedInnerClass.getA());
	System.out.println(obj.getAO());
	
	//Access static inner class
	StaticInnerClass staticInnerClass = new StaticInnerClass();
	staticInnerClass.setB(3);
	
	System.out.println(staticInnerClass.getB());
	System.out.println(obj.getBO());
    }
}
