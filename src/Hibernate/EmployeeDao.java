package Hibernate;

import org.hibernate.SessionFactory;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class EmployeeDao implements EmployeeDaoInterface {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public boolean insertEmployee(Employee emp) {
		if( null == sessionFactory.getCurrentSession().get(Employee.class, emp.getEMPNO()) ) {
			sessionFactory.getCurrentSession().save(emp);
			return true;
		}
		return false;		
	}

	public void updateEmployee(Employee emp) {
		sessionFactory.getCurrentSession().update(emp);
	}

	public Employee getEmployee(Long emp_id) throws Exception {
		Employee emp = (Employee) sessionFactory.getCurrentSession().get(Employee.class, emp_id);
		return emp;
	}

	public void deleteEmployee(Long emp_id) throws Exception {
		Employee emp = getEmployee(emp_id);
		if ( emp != null ) {
			sessionFactory.getCurrentSession().delete(emp);
		}
	}

}
