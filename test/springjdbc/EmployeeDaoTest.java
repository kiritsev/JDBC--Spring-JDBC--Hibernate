package springjdbc;

import java.sql.SQLException;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class EmployeeDaoTest {

	private EmployeeDao employeeDaoBean;

	private String srcTableName;
	private String tmpTableName;

	@Before
	public void initialize() {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "EmployeeDao.xml" });
		BeanFactory beanFactory = context;

		this.employeeDaoBean = (EmployeeDao) beanFactory.getBean("employeeDao");

		this.srcTableName = "EMP";
		this.tmpTableName = "TEST";

		try {
			employeeDaoBean.query("CREATE TABLE " + tmpTableName
					+ " AS ( SELECT * FROM " + srcTableName + " WHERE 1=2 )",
					null);
		} catch (Exception e) {
		}

		employeeDaoBean.setTableName(tmpTableName);
	}

	@Test
	public void insert_record() {
		Employee newEmp = new Employee();
		newEmp.setEmpNo(8888);
		newEmp.seteName("ASilva");
		newEmp.setJob("Fighter");
		newEmp.setMgr(1234);
		newEmp.setHireDate(new Date());
		newEmp.setSal(2500);
		newEmp.setComm(123);
		newEmp.setDeptNo(20);

		employeeDaoBean.insertEmployee(newEmp);
	}

	@Test
	public void select_records() throws SQLException {
		SqlRowSet rs = employeeDaoBean.selectAllEmployees();
		employeeDaoBean.showResult(rs);
	}

	@Test
	public void update_record() {
		Employee emp = new Employee();
		emp.setEmpNo(8888);
		emp.seteName("ASilva");
		emp.setJob("Fighter");
		emp.setMgr(1234);
		emp.setHireDate(new Date());
		emp.setSal(2500);
		emp.setComm(123);
		emp.setDeptNo(21);

		employeeDaoBean.updateEmployee(emp);
	}

	@Test
	public void delete_record() {
		Employee emp = new Employee();
		emp.setEmpNo(8888);
		employeeDaoBean.deleteEmployee(emp);
	}

	@After
	public void finalize() {
		try {
			System.out.println("DROP");
			employeeDaoBean.query("DROP TABLE " + this.tmpTableName, null);
		} catch (Exception e) {

		}
	}
}
