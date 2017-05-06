package test.OopsConcepts;

class X{
    void method(int a){
	System.out.println("One");
    }
    
    void method(double a){
	System.out.println("Two");
    }
}

class Y extends X{
    
    void method(double a){
	System.out.println("Three");
    }
}

class Z extends Y{
    void method(double a){
	System.out.println("Four");
    }
}

public class TestOutput {
    public static void main(String[] args){
	//new Y().method(2);
	
	X x = new Z();
	x.method(1);
	x.method(1d);
	
	Y y = (Y) x;
	y.method(1d);
	
	Z z = (Z) y;
	z.method(1d);
    }
}
