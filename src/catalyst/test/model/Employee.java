package catalyst.test.model;

import java.text.DecimalFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import catalyst.test.util.DateAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {
	
	@XmlAttribute(name="id")
	private Integer employeeId;
	
	@XmlElement(name="name")
	private String name; 
	
	@XmlElement(name="Department")
	private String department;
	
	@XmlElement(name="salary")
	private Integer salary;

	@XmlElement(name="joindate")
	@XmlJavaTypeAdapter(DateAdapter.class)
	private Date joinDate;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String toString() {
		Format dateFormatter = new SimpleDateFormat("MM/dd/yyyy");
		Format salaryFormatter = new DecimalFormat("#,##0");
		
		return "Name: " + name
			+ "\nDepartment: " + department
			+ "\nJoindate: " +  dateFormatter.format(joinDate)
			+ "\nSalary: " + salaryFormatter.format(salary);
	}
	
}

