package hibernateCascadeTest;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Department")
public class Department {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="DEPARTMENT_ID")
	private int departmentId;
	
	@Column(name="DEPARTMENT_NAME")
	private String departmentName;
	
	
	private Set<Employee> employee;

}
