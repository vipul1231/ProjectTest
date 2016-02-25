package testPackage;

class cloneTest implements Cloneable
{
	int number;
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Object clone() throws CloneNotSupportedException
	{
		return super.clone();
	}
	
}

public class CloneAbleTest {
	
	
	public static void main(String[] args)
	{
		cloneTest tst = new cloneTest();
		tst.setNumber(3);
		System.out.println(tst.hashCode());
		try {
			cloneTest obj = (cloneTest) tst.clone();
			System.out.println(obj.getNumber());
			System.out.println(obj.hashCode());
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
