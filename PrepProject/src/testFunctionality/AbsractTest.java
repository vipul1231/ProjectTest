package testFunctionality;


interface test
{
   void getMethod();
}

class C implements test
{

	@Override
	final public void getMethod() {
		// TODO Auto-generated method stub
		
	}
	
}


abstract class TestAbstract
{
	abstract void testThisAbstractClass();
}

abstract class NewTestAbstractClass extends TestAbstract
{
	
}


public class AbsractTest extends NewTestAbstractClass{

	@Override
	public void testThisAbstractClass() {
		// TODO Auto-generated method stub
		
	}

}
