package Hibernate;

import java.util.Set;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DepartmentDao implements DepartmentDaoInterface {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public boolean insertDepartment(Department dpt) {
		if( null == sessionFactory.getCurrentSession().get(Department.class, dpt.getDEPTNO()) ) {
			sessionFactory.getCurrentSession().save(dpt);
			return true;
		}
		return false;	
	}

	public void updateDepartment(Department dpt) {
		sessionFactory.getCurrentSession().update(dpt);
	}

	public Department getDepartment(Long dpt_id) {
		Department dpt = (Department) sessionFactory.getCurrentSession().get(Department.class, dpt_id);
		return dpt;
	}

	public Set<Employee> getDepartmentEmployees(Long dpt_id) {
		Department dpt = null;
		Set<Employee> emps = null;
		dpt = (Department) sessionFactory.getCurrentSession().get(Department.class, dpt_id);
		if( dpt != null ) {
			emps = dpt.getEMPLOYEES();
		}

		return emps;
	}

	public void deleteDepartment(Long dpt_id) {
		Department dpt = getDepartment(dpt_id);
		if ( dpt != null ) {
			sessionFactory.getCurrentSession().delete(dpt);
		}
	}

}
