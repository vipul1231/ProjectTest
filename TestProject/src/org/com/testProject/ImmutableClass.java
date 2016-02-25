package org.com.testProject;

public final class ImmutableClass {
	
	private final String name;
	private final String designation;
	
	private ImmutableClass(String name, String Designation)
	{
		this.name = name;
		this.designation = Designation;
	}

	public static ImmutableClass getInstance(String name, String Designation)
	{
		return new ImmutableClass(name, Designation);
	}

	public String getName() {
		return name;
	}

	public String getDesignation() {
		return designation;
	}
}
