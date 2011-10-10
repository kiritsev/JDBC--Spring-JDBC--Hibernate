package Hibernate;

import java.util.Date;

//import javax.persistence.Id;
//import javax.persistence.*;

//@Entity
//@Table(name = "EMP")
public class Employee {

	//@Id
	private Long EMPNO;
	private String ENAME;
	private String JOB;
	private Long MGR;
	private Date HIREDATE;
	private Long SAL;
	private Long COMM;
	private Long DEPTNO;

	public Employee() {
	}

	public Long getEMPNO() {
		return EMPNO;
	}

	public void setEMPNO(Long eMPNO) {
		EMPNO = eMPNO;
	}

	public String getENAME() {
		return ENAME;
	}

	public void setENAME(String eNAME) {
		ENAME = eNAME;
	}

	public String getJOB() {
		return JOB;
	}

	public void setJOB(String jOB) {
		JOB = jOB;
	}

	public Long getMGR() {
		return MGR;
	}

	public void setMGR(Long mGR) {
		MGR = mGR;
	}

	public Date getHIREDATE() {
		return HIREDATE;
	}

	public void setHIREDATE(Date hIREDATE) {
		HIREDATE = hIREDATE;
	}

	public Long getSAL() {
		return SAL;
	}

	public void setSAL(Long sAL) {
		SAL = sAL;
	}

	public Long getCOMM() {
		return COMM;
	}

	public void setCOMM(Long cOMM) {
		COMM = cOMM;
	}

	public Long getDEPTNO() {
		return DEPTNO;
	}

	public void setDEPTNO(Long dEPTNO) {
		DEPTNO = dEPTNO;
	}
}
