package Hibernate;

import java.util.Set;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class DepartmentDao {

	private static SessionFactory sessionFactory;
	// public final static Logger LOG = Logger.getAnonymousLogger();

	static {
		try {
			 sessionFactory = new Configuration().configure()
			 .buildSessionFactory();

//			Configuration conf = new AnnotationConfiguration()
//					.addAnnotatedClass(Employee.class)
//					.addAnnotatedClass(Department.class).configure();
//			sessionFactory = conf.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public boolean insertDepartment(Department dpt) {
		Session session = null;
		boolean executedSuccessful = false;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(dpt);
			session.getTransaction().commit();
			executedSuccessful = true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Insert error: " + e.getCause().getMessage());
			executedSuccessful = false;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return executedSuccessful;
	}

	public boolean updateDepartment(Department dpt) {
		Session session = null;
		boolean executedSuccessful = false;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(dpt);
			session.getTransaction().commit();
			executedSuccessful = true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Update error: " + e.getCause().getMessage());
			executedSuccessful = false;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return executedSuccessful;
	}

	public Department getDepartment(Long dpt_id) {
		Session session = null;
		Department dpt = null;
		try {
			session = sessionFactory.openSession();
			dpt = (Department) session.get(Department.class, dpt_id);
		} catch (Exception e) {
			System.out.println("Get error: " + e.getCause().getMessage());
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return dpt;
	}

	public Set<Employee> getDepartmentEmployees(Long dpt_id) {
		Session session = null;
		Department dpt = null;
		Set<Employee> emps = null;
		try {
			session = sessionFactory.openSession();
			dpt = (Department) session.get(Department.class, dpt_id);
			emps = dpt.getEMPLOYEES();
		} catch (Exception e) {
			System.out.println("Get error: " + e.getCause().getMessage());
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return emps;
	}

	public boolean deleteDepartment(Long dpt_id) {
		Session session = null;
		Department dpt = null;
		boolean executedSuccessful = false;
		try {
			session = sessionFactory.openSession();
			dpt = getDepartment(dpt_id);
			session.beginTransaction();
			if (dpt != null) {
				session.delete(dpt);
			}
			session.getTransaction().commit();
			executedSuccessful = true;
		} catch (Exception e) {
			System.out.println("Delete error: " + e.getMessage());
			executedSuccessful = false;
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return executedSuccessful;
	}

}
