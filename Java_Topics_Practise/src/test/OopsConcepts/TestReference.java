package test.OopsConcepts;

class SuperParent{
    
    void override(){
	System.out.println("Super parent.");
    }
}

class Parent extends SuperParent{
    
    protected void override(){
	System.out.println("Parent.");
    }
    
}

public class TestReference extends Parent {
    
    public void override() {
	System.out.println("Base");
    }
    
    public static void main(String[] args){
	TestReference testReference = new TestReference();
	testReference.override();
	
	SuperParent superParent = new SuperParent();
	superParent.override();
	
	SuperParent superParent2 = new TestReference();
	superParent2.override();
    }
}
