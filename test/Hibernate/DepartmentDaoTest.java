package Hibernate;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/HibernateDaoBeans.xml" })
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)
@Transactional
public class DepartmentDaoTest {

	@Autowired
	DepartmentDaoInterface dptDao;
	
	public static final Logger LOG=Logger.getLogger(DepartmentDaoTest.class);

	@Test
	public void insert_record() {
		Department newDpt = new Department();
		newDpt.setDEPTNO(30L);
		newDpt.setDNAME("Major");
		newDpt.setLOC("Moscow");
		assertTrue( dptDao.insertDepartment(newDpt) );
	}

	@Test
	public void select_records() throws SQLException {
		Long dpt_id = 30L;
		try {
			Department dpt = dptDao.getDepartment(dpt_id);

			if (dpt != null) {
				assertThat(dpt_id, is(dpt.getDEPTNO()));
			}			
		} catch (Exception e) {
			fail();
		}		
	}

	@Test
	public void update_record() {
		Department newDpt = new Department();
		newDpt.setDEPTNO(30L);
		newDpt.setDNAME("Major");
		newDpt.setLOC("Moscow");

		dptDao.updateDepartment(newDpt);
	}

	@Test
	public void delete_record() throws Exception {
		Long dpt_id = 30L;
		try {
			dptDao.deleteDepartment(dpt_id);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void select_record_and_related_records() {
		Long dpt_id = 11L;

		Set<Employee> emps = dptDao.getDepartmentEmployees(dpt_id);
		if (emps != null) {

			LOG.debug("Departments count: " + emps.size());
			
			Iterator<Employee> it = emps.iterator();
			if (it.hasNext()) {
				Employee emp = it.next();
				assertThat(dpt_id, is(emp.getDEPTNO()));
			}
		}
	}
}
