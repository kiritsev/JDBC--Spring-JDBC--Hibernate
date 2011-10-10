package Hibernate;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class DepartmentDaoTest {

	DepartmentDao dptDao;

	@Before
	public void initialize() {
		this.dptDao = new DepartmentDao();
	}

	@Test
	public void insert_record() {
		Department newDpt = new Department();
		newDpt.setDEPTNO(30L);
		newDpt.setDNAME("Major");
		newDpt.setLOC("Moscow");
		dptDao.insertDepartment(newDpt);
	}

	@Test
	public void select_records() throws SQLException {
		Long dpt_id = 30L;

		Department dpt = dptDao.getDepartment(dpt_id);

		if (dpt != null) {
			assertThat(dpt_id, is(dpt.getDEPTNO()));
		}
	}

	@Test
	public void update_record() {
		Department newDpt = new Department();
		newDpt.setDEPTNO(30L);
		newDpt.setDNAME("Major");
		newDpt.setLOC("Moscow");

		assertTrue(dptDao.updateDepartment(newDpt));
	}

	@Test
	public void delete_record() {
		Long dpt_id = 8888L;

		assertTrue(dptDao.deleteDepartment(dpt_id));
	}

	@Test
	public void select_record_and_related_records() {
		Long dpt_id = 30L;

		Set<Employee> emps = dptDao.getDepartmentEmployees(dpt_id);
		if (emps != null) {
			System.out.println("DPT: " + emps.size());
		}
		Iterator<Employee> it = emps.iterator();
		if (it.hasNext()) {
			Employee emp = it.next();
			assertThat(dpt_id, is(emp.getDEPTNO()));
		}
	}
}
