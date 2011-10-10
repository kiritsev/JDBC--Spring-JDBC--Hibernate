package Hibernate;

import java.util.HashSet;
import java.util.Set;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;

//@Entity
//@Table(name = "DEPT")
public class Department {

	//@Id
	private Long DEPTNO;
	private String DNAME;
	private String LOC;
	//@OneToMany
	//@JoinColumn(name = "DEPTNO")
	private Set<Employee> EMPLOYEES = new HashSet<Employee>();

	public Long getDEPTNO() {
		return DEPTNO;
	}

	public void setDEPTNO(Long dEPTNO) {
		DEPTNO = dEPTNO;
	}

	public String getDNAME() {
		return DNAME;
	}

	public void setDNAME(String dNAME) {
		DNAME = dNAME;
	}

	public String getLOC() {
		return LOC;
	}

	public void setLOC(String lOC) {
		LOC = lOC;
	}

	public void setEMPLOYEES(Set<Employee> eMPLOYEES) {
		EMPLOYEES = eMPLOYEES;
	}

	public Set<Employee> getEMPLOYEES() {
		return EMPLOYEES;
	}
}
