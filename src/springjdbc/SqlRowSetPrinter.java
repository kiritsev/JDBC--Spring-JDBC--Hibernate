package springjdbc;

import org.springframework.jdbc.support.rowset.SqlRowSet;

public interface SqlRowSetPrinter {
	public void print(SqlRowSet rs);
}