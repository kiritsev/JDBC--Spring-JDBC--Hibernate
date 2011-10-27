package service;

import org.springframework.transaction.annotation.Transactional;

import Hibernate.Employee;

public interface EmployeeServiceInteface {

	@Transactional
	public abstract void insert(Employee newEmp) throws Exception;

}