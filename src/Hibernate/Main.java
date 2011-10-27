package Hibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Hibernate.Employee;
import Hibernate.EmployeeDao;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	

		EmployeeDaoInterface employeeDao;

		ApplicationContext context = new ClassPathXmlApplicationContext(
		new String[] { "HibernateDaoBeans.xml" } );

		employeeDao = (EmployeeDaoInterface) context.getBean("employeeDao");
		
		
		Long empId = 8881L;
		String empName = null;
		try {
			Employee emp = employeeDao.getEmployee(empId);
			empName = emp.getENAME();
			System.out.println("EmpName:" + empName);
		} catch (Exception e) {
			System.out.println("DAO ERROR:");
			e.printStackTrace();
		}
		
	}

}
