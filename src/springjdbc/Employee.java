package springjdbc;

import java.util.Date;

public class Employee {
	private Integer empNo;
	private String eName;
	private String job;
	private Integer mgr;
	private Date hireDate;
	private Integer sal;
	private Integer comm;
	private Integer deptNo;

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	public Integer getEmpNo() {
		return empNo;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public String geteName() {
		return eName;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getJob() {
		return job;
	}

	public void setMgr(Integer mgr) {
		this.mgr = mgr;
	}

	public Integer getMgr() {
		return mgr;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setSal(Integer sal) {
		this.sal = sal;
	}

	public Integer getSal() {
		return sal;
	}

	public void setComm(Integer comm) {
		this.comm = comm;
	}

	public Integer getComm() {
		return comm;
	}

	public void setDeptNo(Integer deptNo) {
		this.deptNo = deptNo;
	}

	public Integer getDeptNo() {
		return deptNo;
	}

}
