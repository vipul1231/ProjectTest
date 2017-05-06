package test.AccessModifiers;

public class DefaultAccessModifiers extends ProtectedAccessModifiers{
    
    public void test(){
	System.out.println(sumOfNumber(1));
    }
    
    public static void main(String[] args){
	DefaultAccessModifiers defaultAccessModifiers = new DefaultAccessModifiers();
	ProtectedAccessModifiers protectedAccessModifiers = new ProtectedAccessModifiers();
	protectedAccessModifiers.sumOfNumber(2);
	defaultAccessModifiers.test();
    }
}
