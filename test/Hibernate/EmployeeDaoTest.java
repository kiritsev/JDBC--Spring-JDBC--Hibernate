package Hibernate;

import static org.junit.Assert.*;

import java.util.Date;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.test.context.transaction.TransactionConfiguration;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/HibernateDaoBeans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class EmployeeDaoTest {

	@Autowired
	EmployeeDaoInterface empDao;

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

		assertTrue(empDao.insertEmployee(newEmp));
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
