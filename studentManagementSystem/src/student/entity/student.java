package student.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class student {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int studentId;
	
	private String firstName;
	private String department;
	private String country;
	
	public student()
	{
		
	}
	
	public student(int studentId, String firstName, String department, String country) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.department = department;
		this.country = country;
	}

	public student(String firstName, String department, String country) {
		super();
		this.firstName = firstName;
		this.department = department;
		this.country = country;
	}

	

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String name) {
		this.firstName= name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
