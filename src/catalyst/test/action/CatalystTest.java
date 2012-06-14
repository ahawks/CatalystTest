package catalyst.test.action;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import catalyst.test.model.Employee;
import catalyst.test.model.EmployeeData;
import catalyst.test.util.sorting.IdComparator;
import catalyst.test.util.sorting.JoinDateComparator;
import catalyst.test.util.sorting.SalaryComparator;

public class CatalystTest {
	private JAXBContext jc; 
	public static void main(String[] args) throws FileNotFoundException {
		CatalystTest test = new CatalystTest();
		test.executeTest();

	}

	public void executeTest() {
		
		EmployeeData employeeData = null;
		try {
			jc = JAXBContext.newInstance(EmployeeData.class);
			employeeData = getEmployeeData();
		} catch (JAXBException e) {
			System.err.println("Could not parse XML. Invalid format.");
			e.printStackTrace();
			return;
		} catch (FileNotFoundException e) {
			System.err.println("Unable to locate XML file to parse.");	
			e.printStackTrace();
			return;
		}
		if (employeeData.getEmployees() == null || employeeData.getEmployees().size() == 0) {
			System.err.println("No Employee records.");
			return;
		}

		System.out.println(employeeData.getEmployees().size() + " records found.");
		System.out.println("Record #3 from unsorted list:");
		System.out.println(employeeData.getEmployees().get(2));
		System.out.println();
		
		// get highest and lowest salary employees
		Collections.sort(employeeData.getEmployees(), new SalaryComparator());
		List<Employee> employees = employeeData.getEmployees();
		System.out.println("Highest salary employee:");
		System.out.println(employees.get(employees.size()-1));
	
		System.out.println();

		System.out.println("Lowest salary employee:");
		System.out.println(employees.get(0));
		
		System.out.println();

		// Get earliest join date employee
		Collections.sort(employeeData.getEmployees(), new JoinDateComparator());
		System.out.println("Earliest Join Date:");
		System.out.println(employees.get(0));
		
		Collections.sort(employeeData.getEmployees(),new IdComparator());
		int newId = employeeData.getEmployees().get(
					employeeData.getEmployees().size()-1).getEmployeeId() + 1;
		
		Employee ishaan = new Employee();
		ishaan.setName("Ishaan");
		ishaan.setDepartment("Marketing");
		ishaan.setJoinDate(new Date(2012,06,01));
		ishaan.setSalary(15000);
		ishaan.setEmployeeId(newId);
		
		// add a new employee
		employeeData.getEmployees().add(ishaan);
		
		
		// write the new list of employees out to a file
		try {
			marshallEmployees(employeeData);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	private void printAllEmployees(EmployeeData employees) {
		for (Employee employee : employees.getEmployees()) {
			System.out.println(employee);
			System.out.println();
		}
	}
	
	private EmployeeData getEmployeeData() throws JAXBException, FileNotFoundException {
		JAXBContext jaxbContext;

		Unmarshaller um = jc.createUnmarshaller();
		EmployeeData employeeData = (EmployeeData)um.unmarshal(new FileInputStream("inbound.xml"));
		return employeeData;
	}
	
	private void marshallEmployees(EmployeeData data) throws FileNotFoundException, JAXBException {
		
		//Create marshaller
		Marshaller m = jc.createMarshaller();
		m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		//Marshal object into file.
		m.marshal(data, new java.io.FileOutputStream( "output.xml" ));
	}

}
