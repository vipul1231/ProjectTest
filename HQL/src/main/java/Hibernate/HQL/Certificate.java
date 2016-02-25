package Hibernate.HQL;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name ="certificate")
public class Certificate {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name = "certificate_name")
	private String name;
	
	@MapsId
	@ManyToOne(fetch=FetchType.EAGER,cascade = {CascadeType.ALL})
	@JoinColumn(name="employee_id")
	private Employee employee;
	
	public Certificate() {
		// TODO Auto-generated constructor stub
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Certificate(String name) {		
		this.name = name;
	}

	public int getId() {
		return id;
	}
	
	public boolean equals(Object obj) {
	      if (obj == null) return false;
	      if (!this.getClass().equals(obj.getClass())) return false;

	      Certificate obj2 = (Certificate)obj;
	      if((this.id == obj2.getId()) && (this.name.equals(obj2.getName())))
	      {
	         return true;
	      }
	      return false;
	   }
	   public int hashCode() {
	      int tmp = 0;
	      tmp = ( id + name ).hashCode();
	      return tmp;
	   }

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
