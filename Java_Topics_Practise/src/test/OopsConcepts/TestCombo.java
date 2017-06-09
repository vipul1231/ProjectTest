package test.OopsConcepts;

class D{
    int method(int i){
	return i *i;
    }
}

class B extends D{
    
    double method(double d){
	System.out.println("Double :"+d);
	return d /=d;
    }
    
}

class C extends B{
    
    float method(float f){
	System.out.println("Float");
	return f+= f;
    }
}

public class TestCombo {
    
    void overLoadMethoA(D a){
	System.out.println("ONE");
    }
    
    void overLoadMethoA(B b){
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
	testCombo.overLoadMethoA(c);
	testCombo.overLoadMethoA(new Object());
	
	System.out.println(c.method(13.12));
    }

}
