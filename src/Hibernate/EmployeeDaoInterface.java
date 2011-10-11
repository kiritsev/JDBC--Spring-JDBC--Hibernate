package Hibernate;

import org.hibernate.SessionFactory;

public interface EmployeeDaoInterface {

	public void setSessionFactory(SessionFactory sessionFactory);
	
	public boolean insertEmployee(Employee emp);

	public void updateEmployee(Employee emp);
	
	public Employee getEmployee(Long emp_id) throws Exception;

	public void deleteEmployee(Long emp_id) throws Exception;

}
