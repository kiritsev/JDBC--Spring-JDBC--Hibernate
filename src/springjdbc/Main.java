package springjdbc;

import java.sql.SQLException;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

@SuppressWarnings("deprecation")
public class Main {
	public static void main(String[] args) throws SQLException {

		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource(
				"EmployeeDao.xml"));

		EmployeeDao myBean = (EmployeeDao) beanFactory.getBean("employeeDao");

		myBean.showTable();

	}
}
