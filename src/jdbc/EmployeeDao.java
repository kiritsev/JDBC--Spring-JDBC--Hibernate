package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDao {

	private Connection connection;

	private String driver = "oracle.jdbc.driver.OracleDriver";

	public EmployeeDao(String url, String user, String password)
			throws ClassNotFoundException, SQLException {

		connect(url, user, password);
	}

	public void disconnect() throws SQLException {
		if (this.connection != null) {
			this.connection.close();
		}
	}

	public ResultSet makeRequest(String query) throws SQLException {
		Statement stmt = this.connection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;
	}

	private void connect(String url, String user, String password)
			throws ClassNotFoundException, SQLException {
		Class.forName(this.driver);
		this.connection = DriverManager.getConnection(url, user, password);
	}

	private static void printResultSet(ResultSet rs) throws SQLException {
		printResultSetHeader(rs);
		printResultSetBody(rs);
	}

	private static void printResultSetBody(ResultSet rs) throws SQLException {
		ResultSetMetaData md = rs.getMetaData();
		int columnCount = md.getColumnCount();
		int i;

		while (rs.next()) {
			for (i = 1; i <= columnCount; i++) {
				System.out.print(rs.getString(i) + "\t\t");
			}
			System.out.println();
		}
	}

	private static void printResultSetHeader(ResultSet rs) throws SQLException {
		ResultSetMetaData md = rs.getMetaData();
		int columnCount = md.getColumnCount();
		int i;

		for (i = 1; i <= columnCount; i++) {
			System.out.print(md.getColumnName(i) + "\t\t");
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws Exception {
		EmployeeDao employeeDao = null;
		ResultSet rs;
		String url = "jdbc:oracle:thin:@ora92.dfu.i-teco.ru:1521:backo";
		String user = "scott";
		String password = "scott";
		
		try {
			employeeDao = new EmployeeDao(url, user, password);
			rs = employeeDao.makeRequest("SELECT * FROM EMP");
			printResultSet(rs);
		} finally {
			if (employeeDao != null) {
				employeeDao.disconnect();
			}
		}
	}
}
