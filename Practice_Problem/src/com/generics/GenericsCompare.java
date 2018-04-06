package com.generics;


/**
 * This class test generics for comparing two methods
 * 
 * @author Vipul
 *
 * @param <F>
 */
public class GenericsCompare<F> {
    
    F object;

    @SuppressWarnings("unchecked")
    private <E extends Comparable<E>> void compare(E e){
	System.out.println(e.compareTo((E) object));
    }
    
    public static void main(String[] args)
    {
	GenericsCompare<Integer> obj = new GenericsCompare<>();
	obj.setObject(new Integer(3));
	obj.compare(1);
    }
    
    public F getObject() {
        return object;
    }

    public void setObject(F object) {
        this.object = object;
    }

}
