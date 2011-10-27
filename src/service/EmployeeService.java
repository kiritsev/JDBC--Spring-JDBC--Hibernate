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

//@Transactional(rollbackFor=Exception.class)
public class EmployeeService implements EmployeeServiceInteface{
	
	EmployeeDaoInterface employeeDao;

	public void setEmployeeDao(EmployeeDaoInterface employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@Override
	@Transactional
	public void insert( Employee newEmp ) throws Exception {
//		System.out.println("TRANSACTIOIN:" +
//				org.springframework.transaction.support.
//				TransactionSynchronizationManager.isActualTransactionActive());
		employeeDao.insertEmployee(newEmp);
		System.out.println("thtow Stoppage");
		//throw new RuntimeException("Stoppage");
	}
	
	public static void main(String[] args) throws Exception {
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "HibernateDaoBeans.xml" });
		EmployeeServiceInteface service = (EmployeeServiceInteface) context.getBean("employeeService");
		
		System.out.println("Insert begin");

		Long empId = 8882L;
		String empName = "Josh";
		Employee newEmp = new Employee();
		newEmp.setEMPNO(empId);
		newEmp.setENAME(empName);
		
		try {
			service.insert(newEmp);
		} catch (Exception e) {
			System.out.println("Badness:" + e.getMessage());
		}
		
		System.out.println("Insert end");

	}
	
}
