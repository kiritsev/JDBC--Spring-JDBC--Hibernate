package springjdbc;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class EmployeeDao {

	private JdbcTemplate jdbcTemplate;
	private String tableName;
	private SqlRowSetPrinter sqlRowSetPrinter;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public void setSqlRowSetPrinter(SqlRowSetPrinter sqlRowSetPrinter) {
		this.sqlRowSetPrinter = sqlRowSetPrinter;
	}

	public void insertEmployee(Employee emp) {
		String query = " INSERT INTO " + this.tableName + " ";
		query += " ( EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO ) "
				+ " VALUES " + " (?, ?, ?, ?, ?, ?, ?, ?) ";

		this.jdbcTemplate.update(query, emp.getEmpNo(), emp.geteName(),
				emp.getJob(), emp.getMgr(), emp.getHireDate(), emp.getSal(),
				emp.getComm(), emp.getDeptNo());
	}

	public SqlRowSet selectAllEmployees() {
		String query = "SELECT * FROM " + this.tableName;
		SqlRowSet rs = this.jdbcTemplate.queryForRowSet(query);
		return rs;
	}

	public void updateEmployee(Employee emp) {
		String query = "UPDATE " + this.tableName + " ";
		query += " SET ENAME = ?, JOB = ?, MGR = ?, "
				+ " HIREDATE = ?, SAL = ?, COMM = ?, DEPTNO = ? "
				+ " WHERE EMPNO = ?";

		this.jdbcTemplate.update(query, emp.geteName(), emp.getJob(),
				emp.getMgr(), emp.getHireDate(), emp.getSal(), emp.getComm(),
				emp.getDeptNo(), emp.getEmpNo());
	}

	public void deleteEmployee(Employee emp) {
		String query = " DELETE FROM " + this.tableName + " ";
		query += " WHERE EMPNO = ? ";

		this.jdbcTemplate.update(query, emp.getEmpNo());
	}

	public void showResult(SqlRowSet rs) {
		sqlRowSetPrinter.print(rs);
	}

	public SqlRowSet query(String query, Object[] objects) {
		return this.jdbcTemplate.queryForRowSet(query, objects);
	}

}
