package test.AccessModifiers;

public class ProtectedAccessModifiers {
  
    /**
     * This can be access out side of package through subclassing
     * 
     * @return
     */
    protected int sumOfNumber(){
	return 3+4;
    }
    
    
    /**
     * This method will be availble in same package
     * 
     * @param a
     * @return
     */
    int sumOfNumber(int a){
	return a+2;
    }

}
