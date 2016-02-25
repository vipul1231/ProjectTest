package hibernateCascadeTest;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="EmployeeTest")
public class Employee {
	
	private int employeeId;
	
	private String firstName;
	
	private String lastName;
	
	private Date birthDate;
	
	private String cellPhone;
	
	

}
