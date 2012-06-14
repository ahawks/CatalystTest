package catalyst.test.util.sorting;

import catalyst.test.model.Employee;


public class IdComparator implements java.util.Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		if (o1 == null || o2 == null || 
			o1.getEmployeeId() == null || o2.getEmployeeId() == null) {
			return 0;
		}
		return o1.getEmployeeId().compareTo(o2.getEmployeeId());
	}
}
