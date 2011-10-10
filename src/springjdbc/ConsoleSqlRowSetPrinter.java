package springjdbc;

import java.sql.SQLException;

import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.jdbc.support.rowset.SqlRowSetMetaData;

public class ConsoleSqlRowSetPrinter implements SqlRowSetPrinter {
	public void print(SqlRowSet rs) {
		try {
			printHeader(rs);
			printBody(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void printHeader(SqlRowSet rs) throws SQLException {
		SqlRowSetMetaData md = rs.getMetaData();
		int columnCount = md.getColumnCount();
		int i;

		for (i = 1; i <= columnCount; i++) {
			System.out.print(md.getColumnName(i) + "\t\t");
		}
		System.out.println();
	}

	private static void printBody(SqlRowSet rs) throws SQLException {
		SqlRowSetMetaData md = rs.getMetaData();
		int columnCount = md.getColumnCount();
		int i;

		while (rs.next()) {
			for (i = 1; i <= columnCount; i++) {
				System.out.print(rs.getString(i) + "\t\t");
			}
			System.out.println();
		}
	}
}
