package catalyst.test.util.sorting;

import catalyst.test.model.Employee;


public class NameComparator implements java.util.Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		if (o1 == null || o2 == null || 
			o1.getName() == null || o2.getName() == null) {
			return 0;
		}
		return o1.getName().compareTo(o2.getName());
	}
}
