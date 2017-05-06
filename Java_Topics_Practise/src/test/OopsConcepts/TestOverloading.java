package test.OopsConcepts;

import java.sql.SQLException;

public class TestOverloading {
    
    private int calculateSum(int a, int b) throws SQLException{
	System.out.println("From int");
	System.out.println(a+b);
	return a+b;
    }
    
    private void calculateSum(float a, float b){
	System.out.println("From float");
	System.out.println(a+b);
    }
    
    private void calculateSum(double a, double b) throws Exception{
	System.out.println("From double");
	System.out.println(a+b);
	
    }
    
    public static void main(String[] args){
	TestOverloading object = new TestOverloading();
	try {
	    object.calculateSum(1, 2);
	} catch (SQLException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	object.calculateSum(1f, 4f);
	try {
	    object.calculateSum(1d, 5d);
	} catch (Exception e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }
}
