package test.OopsConcepts;

interface CG{
    
    int A();
    
    class test{
	
	int k = 10;
	
	int returnK(){
	    return k;
	}
    }
}

abstract class FG implements CG{
    
}


public final class Immutable {
    
    final int a;
    final int b;
    
    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
    
    public Immutable(int a, int b) {
	// TODO Auto-generated constructor stub
	this.a = a;
	this.b = b;
    }

    public int A() {
	// TODO Auto-generated method stub
	return 0;
    }
    
    public static void main(String[] args){
	CG.test obj = new CG.test();
	System.out.println(obj.returnK());
    }
}
