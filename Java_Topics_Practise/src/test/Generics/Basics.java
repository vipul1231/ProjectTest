package test.Generics;

import java.util.List;

/**
 * Generics was added in Java 5 to remove class cast exception
 * 
 * @author Vipul_Anky
 *
 */
public class Basics<E> {
    
    E e;
    
    public E getE() {
        return e;
    }

    public void setE(E e) {
        this.e = e;
    }
    
    /**
     * Generics static function
     * 
     * @param obj1
     * @param obj2
     * @return
     */
    public static <E> boolean isEqual(Basics<E> obj1, Basics<E> obj2){
	
	if(obj1.getE() instanceof String && obj2.getE() instanceof String){
	    String string1 = (String) obj1.getE();
	    String string2 = (String) obj2.getE();
	    return string1.equals(string2);
	}
	
	else if(obj1.getE() instanceof Number && obj2.getE() instanceof Number){
	    return obj1.getE() == obj2.getE();
	}
	
	else{
	    return false;
	}
    }
    
    public static <E extends Comparable<E>> int compare(E e1, E e2){
	
	return e1.compareTo(e2);
    }
    
    @Override
    public boolean equals(Object obj) {
	// TODO Auto-generated method stub
	return super.equals(obj);
    }

    public static void main(String[] args){
	Basics<String> basics = new Basics<String>();
	basics.setE("Vipul1");
	System.out.println(basics.getE());
	
	Basics<String> basics1 = new Basics<String>();
	basics1.setE("Vipul");
	System.out.println(basics1.getE());
	
	
	Basics<Integer> integer = new Basics<Integer>();
	integer.setE(1);
	Basics<Integer> integer1 = new Basics<Integer>();
	integer1.setE(1);
	System.out.println(integer.getE());
	//System.out.println(isEqual(basics, integer));
	System.out.println(isEqual(basics, basics1));
	System.out.println(compare(basics.getE(), basics1.getE()));
	System.out.println(compare(integer.getE(), integer1.getE()));
    }
    
    void addValueToList(List<? extends Number> items){
	
    }
}
