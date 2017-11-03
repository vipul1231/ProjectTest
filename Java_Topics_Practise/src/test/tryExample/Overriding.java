package test.tryExample;


class A{
    
    public int temp = 2;
    
    int run(int var){
	
	return var+=3;
    }
    
    
    class B {
	
	B(){
	    System.out.println("Constructue B");
	}
	
	
	void run() {
	    temp = 3;
	}
    }
    
    static class C {
	
	C(){
	    
	}
	
	void run(){
	    System.out.println();
	}
    }
}

public class Overriding  extends A{
    
    {
	final String s;
	s = new String();
	System.out.println("String"+s);
    }
    
    public void run(){
	temp = 3;
    }
    
    public static void main(String[] args){
	int var = 0;
	Overriding obj = new Overriding();
	obj.run(var++);
	System.out.println(var);
	
	byte a = 4;
	byte b = 6;
	short c = 32767;
	
	String str = "Stop";
	
	String integer = null;
	str.concat("1");
	System.out.println(b%a + ", ");
	System.out.println(b+integer);
	
	int i = 2, j=3,k=10;
	
	for(;i<6;i++){
	    j = ++j + k++;
	    System.out.println(j+k);
	    
	}
	
	//obj.run();
	
	A obj1 = new A();
	
	B obj2= obj1.new B();
	A.C obj3 = new A.C();
	
	System.out.println(obj.temp);
    }

}
