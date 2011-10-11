package Hibernate;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Date;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeDaoTest {

	EmployeeDaoInterface empDao;

	@Before
	public void initialize() {
		//this.empDao = new EmployeeDao();
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "HibernateDaoBeans.xml" } );

		this.empDao = (EmployeeDaoInterface) context.getBean("employeeDao");

	}

	@Test
	public void insert_record() {
		Employee newEmp = new Employee();
		newEmp.setEMPNO(8888L);
		newEmp.setENAME("Josh");
		newEmp.setJOB("Manager");
		newEmp.setMGR(1234L);
		newEmp.setHIREDATE(new Date());
		newEmp.setSAL(2500L);
		newEmp.setCOMM(123L);
		newEmp.setDEPTNO(20L);

		assertTrue( empDao.insertEmployee(newEmp) );
	}

	@Test
	public void select_records() throws Exception {
		Long emp_id = 8888L;
		try {
			Employee emp = empDao.getEmployee(emp_id);
			
			if (emp != null) {
				assertThat(emp_id, is(emp.getEMPNO()));
			}			
		} catch (Exception e) {
			fail();
		}
		
	}

	@Test
	public void update_record() {
		Employee newEmp = new Employee();
		newEmp.setEMPNO(8888L);
		newEmp.setENAME("Josh");
		newEmp.setJOB("Hunter");
		newEmp.setMGR(1234L);
		newEmp.setHIREDATE(new Date());
		newEmp.setSAL(2500L);
		newEmp.setCOMM(123L);
		newEmp.setDEPTNO(20L);

		empDao.updateEmployee(newEmp);
	}

	@Test
	public void delete_record() {
		Long emp_id = 8888L;
		try {
			empDao.deleteEmployee(emp_id);
		} catch (Exception e) {
			fail();
		}
	}
}
