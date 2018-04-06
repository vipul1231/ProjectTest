package test;


/**
 * Hello world!
 *
 */

public class App{
	
	String name;
	int age;
	
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public void throwException() throws Exception
	{
		throw new Exception();
	}
}
