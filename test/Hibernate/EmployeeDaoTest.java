package Hibernate;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.Date;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

public class EmployeeDaoTest {

	EmployeeDao empDao;

	@Before
	public void initialize() {
		this.empDao = new EmployeeDao();
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

		empDao.insertEmployee(newEmp);
	}

	@Test
	public void select_records() throws SQLException {
		Long emp_id = 8888L;

		Employee emp = empDao.getEmployee(emp_id);

		if (emp != null) {
			assertThat(emp_id, is(emp.getEMPNO()));
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

		assertTrue(empDao.updateEmployee(newEmp));
	}

	@Test
	public void delete_record() {
		Long emp_id = 8888L;

		assertTrue(empDao.deleteEmployee(emp_id));
	}
}
