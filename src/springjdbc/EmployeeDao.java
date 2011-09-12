package springjdbc;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;

@SuppressWarnings("deprecation")
public class EmployeeDao {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void showTable() throws SQLException {
		SqlRowSet rs = this.jdbcTemplate.queryForRowSet("SELECT * FROM EMP");
		printResultSet(rs);
	}

	private void printResultSet(SqlRowSet rs) throws SQLException {
		printResultSetHeader(rs);
		printResultSetBody(rs);
	}

	private void printResultSetBody(SqlRowSet rs) throws SQLException {
		SqlRowSetMetaData md = rs.getMetaData(); // getMetaData();
		int columnCount = md.getColumnCount();
		int i;

		while (rs.next()) {
			for (i = 1; i <= columnCount; i++) {
				System.out.print(rs.getString(i) + "\t\t");
			}
			System.out.println();
		}
	}

	private void printResultSetHeader(SqlRowSet rs) throws SQLException {
		SqlRowSetMetaData md = rs.getMetaData();
		int columnCount = md.getColumnCount();
		int i;

		for (i = 1; i <= columnCount; i++) {
			System.out.print(md.getColumnName(i) + "\t\t");
		}
		System.out.println();
	}
}
