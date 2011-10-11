package Hibernate;

import java.util.Set;

import org.hibernate.SessionFactory;

public interface DepartmentDaoInterface {

	public void setSessionFactory(SessionFactory sessionFactory);
	
	public boolean insertDepartment(Department emp);

	public void updateDepartment(Department emp);
	
	public Department getDepartment(Long dpt_id) throws Exception;

	public Set<Employee> getDepartmentEmployees(Long dpt_id);
	
	public void deleteDepartment(Long dpt_id) throws Exception;

}
