package catalyst.test.util.sorting;

import catalyst.test.model.Employee;


public class SalaryComparator implements java.util.Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		if (o1 == null || o2 == null || 
			o1.getSalary() == null || o2.getSalary() == null) {
			return 0;
		}
		return o1.getSalary().compareTo(o2.getSalary());
	}
}
