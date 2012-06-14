package catalyst.test.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="EmployeeData")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeData {
	
	public EmployeeData() {
		employees = new ArrayList<Employee>();
	}
	
	@XmlElement(name="row")
	List<Employee> employees;

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
}
