package catalyst.test.util.sorting;

import catalyst.test.model.Employee;


public class JoinDateComparator implements java.util.Comparator<Employee> {

	@Override
	public int compare(Employee o1, Employee o2) {
		if (o1 == null || o2 == null || 
			o1.getJoinDate() == null || o2.getJoinDate() == null) {
			return 0;
		}
		return o1.getJoinDate().compareTo(o2.getJoinDate());
	}
}
