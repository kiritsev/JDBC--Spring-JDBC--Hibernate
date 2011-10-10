package Hibernate;

//import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class EmployeeDao {

	private static SessionFactory sessionFactory;
	// public final static Logger LOG = Logger.getAnonymousLogger();

	static {
		try {
			 sessionFactory = new Configuration().configure()
			 .buildSessionFactory();

//			Configuration conf = new AnnotationConfiguration()
//					.addAnnotatedClass(Employee.class).configure();
//			sessionFactory = conf.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public boolean insertEmployee(Employee emp) {
		Session session = null;
		boolean executedSuccessful = false;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(emp);
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

	public boolean updateEmployee(Employee emp) {
		Session session = null;
		boolean executedSuccessful = false;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(emp);
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

	public Employee getEmployee(Long emp_id) {
		Session session = null;
		Employee emp = null;
		try {
			session = sessionFactory.openSession();
			emp = (Employee) session.get(Employee.class, emp_id);
		} catch (Exception e) {
			System.out.println("Get error: " + e.getCause().getMessage());
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return emp;
	}

	public boolean deleteEmployee(Long emp_id) {
		Session session = null;
		Employee emp = null;
		boolean executedSuccessful = false;
		try {
			session = sessionFactory.openSession();
			emp = getEmployee(emp_id);
			session.beginTransaction();
			if (emp != null) {
				session.delete(emp);
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
