package service;

import org.springframework.transaction.annotation.Transactional;

import Hibernate.Employee;

public interface EmployeeServiceInteface {

	@Transactional
	void insert_two_guys() throws Exception;

}