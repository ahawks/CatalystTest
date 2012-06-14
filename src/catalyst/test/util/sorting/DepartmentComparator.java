package catalyst.test.util.sorting;

import catalyst.test.model.Employee;


public class DepartmentComparator implements java.util.Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		if (o1 == null || o2 == null || 
			o1.getDepartment() == null || o2.getDepartment() == null) {
			return 0;
		}
		return o1.getDepartment().compareTo(o2.getDepartment());
	}
}
