package springjdbc;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class EmployeeDao {

	private NamedParameterJdbcTemplate namedParameterJdbcTemplate ;
	private String tableName;
	private SqlRowSetPrinter sqlRowSetPrinter;

	public void setDataSource(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
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
				+ " VALUES " + " (:empNo, :eName, :job, :mgr, :hireDate, :sal, :comm, :deptNo) ";
		
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(emp);
		
		this.namedParameterJdbcTemplate.update(query, namedParameters);
	}

	public SqlRowSet selectAllEmployees() {
		String query = "SELECT * FROM " + this.tableName;
		SqlRowSet rs = this.query(query, null);
		return rs;
	}

	public void updateEmployee(Employee emp) {

		String query = "UPDATE " + this.tableName + " ";
		query += " SET ENAME = :eName, JOB = :job, MGR = :mgr, "
				+ " HIREDATE = :hireDate, SAL = :sal, COMM = :comm, DEPTNO = :deptNo "
				+ " WHERE EMPNO = :empNo";
		
		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(emp);

		this.namedParameterJdbcTemplate.update(query, namedParameters);
	}

	public void deleteEmployee(Employee emp) {
		String query = " DELETE FROM " + this.tableName + " ";
		query += " WHERE EMPNO = :empNo ";

		SqlParameterSource namedParameters = new BeanPropertySqlParameterSource(emp);
		
		this.namedParameterJdbcTemplate.update(query, namedParameters);
	}

	public void showResult(SqlRowSet rs) {
		sqlRowSetPrinter.print(rs);
	}

	public SqlRowSet query(String query, Map<String,?> paramMap) {
		return this.namedParameterJdbcTemplate.queryForRowSet(query, paramMap);
	}

}
