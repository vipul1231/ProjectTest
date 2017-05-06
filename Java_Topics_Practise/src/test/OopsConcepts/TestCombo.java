package test.OopsConcepts;

class D{
    
}

class B extends D{
    
}

class C extends B{
    
}

public class TestCombo {
    
    void overLoadMethoA(D a){
	System.out.println("ONE");
    }
    
    static void overLoadMethoA(B b){
	System.out.println("TWO");
    }

    void overLoadMethoA(Object c){
	System.out.println("THREE");
    }
    
    /*void overLoadMethoA(C c){
	System.out.println("From C");
    }*/
    
    public static void main(String[] args){
	TestCombo testCombo = new TestCombo();
	C c = new C();
	overLoadMethoA(c);
	testCombo.overLoadMethoA(new Object());
    }

}
