package springjdbc;

import java.sql.SQLException;
import java.util.Date;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

//import org.springframework.beans.factory.BeanFactory;
//import org.springframework.beans.factory.xml.XmlBeanFactory;
//import org.springframework.core.io.ClassPathResource;

//@SuppressWarnings("deprecation")
public class Main {
	public static void main(String[] args) throws SQLException {
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "EmployeeDao.xml" });
		BeanFactory beanFactory = context;

		EmployeeDao employeeDaoBean = (EmployeeDao) beanFactory.getBean("employeeDao");
		
		
		Employee emp = new Employee();
		emp.setEmpNo(8811);
		emp.seteName("XSilva");
		emp.setJob("Fighter");
		emp.setMgr(1234);
		emp.setHireDate(new Date());
		emp.setSal(2500);
		emp.setComm(123);
		emp.setDeptNo(21);
		
		System.out.println( "Result:" );
		
		employeeDaoBean.updateEmployee(emp);
		
		//SqlRowSet rs = employeeDaoBean.selectAllEmployees();
		//employeeDaoBean.showResult(rs);

	}
}
