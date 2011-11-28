package service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import Hibernate.Employee;
import Hibernate.EmployeeDaoInterface;

public class EmployeeService implements EmployeeServiceInteface{
	
	EmployeeDaoInterface employeeDao;

	public void setEmployeeDao(EmployeeDaoInterface employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@Override
	public void insert_two_guys() throws Exception {

		Employee newEmp1 = new Employee();
		newEmp1.setEMPNO(111L);
		newEmp1.setENAME("Josh");
		
		Employee newEmp2 = new Employee();
		newEmp2.setEMPNO(222L);
		newEmp2.setENAME("Jon");
		
		employeeDao.insertEmployee(newEmp1);
		employeeDao.insertEmployee(newEmp2);
		
		System.out.println("Throw stoppage here");
		//throw new RuntimeException("Let's rollback");
	}
	
	public static void main(String[] args) throws Exception {
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "HibernateDaoBeans.xml" });
		EmployeeServiceInteface service = (EmployeeServiceInteface) context.getBean("employeeService");
		
		System.out.println("Insert begin");

		
		try {
			service.insert_two_guys();
		} catch (Exception e) {
			System.out.println("Badness happened: 	" + e.getMessage());
		}
		
		System.out.println("Insert end");

	}
	
}
