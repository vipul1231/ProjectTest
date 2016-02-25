package testFunctionality;

final public class ImmutableClass {
	
	private final int employeeId;
	
	private final String employeeAdd;
	
	private ImmutableClass(int empId, String empAddress)
	{
		this.employeeId = empId;
		this.employeeAdd = empAddress;
	}

	public static ImmutableClass getInstance(int empId, String empAddress)
	{
		return new ImmutableClass(empId, empAddress);
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public String getEmployeeAdd() {
		return employeeAdd;
	}
	
}
