package Hibernate.HQL;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="first_name")
	private String first_name;
	
	@Column(name="last_name")
	private String last_name;
	
	@Column(name="salary")
	private Integer salary;
	
	@ManyToOne(fetch=FetchType.EAGER,cascade = {CascadeType.ALL})
	private Address address;
	
	@OneToMany(fetch=FetchType.EAGER,cascade = {CascadeType.ALL}, mappedBy="employee")
	private Set<Certificate> set = new HashSet<Certificate>();
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public Set<Certificate> getSet() {
		return set;
	}

	public void setSet(Set<Certificate> set) {
		this.set = set;
	}

	public Employee(String fname, String lname, Integer salary) {
		this.first_name = fname;
		this.last_name = lname;
		this.salary = salary;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
}
