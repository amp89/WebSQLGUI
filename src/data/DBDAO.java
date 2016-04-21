package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBDAO {

	ResultSet result;
	private static final String URL = "jdbc:mysql://localhost:3306/companydb";
	private static final String username = "student";
	private static final String password = "student";

	private static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
	
	public Results doQuery(String query) throws SQLException{
		Results r = null;
		if(query.trim().toLowerCase().startsWith("select".toLowerCase())  ||  query.trim().toLowerCase().startsWith("desc".toLowerCase())  ||  query.trim().toLowerCase().startsWith("show".toLowerCase())){
			System.out.println("select query: " + query);
			r = getResults(query);
		}
		else{
			System.out.println("modify query: " + query);
			r = updateDatabase(query);
		}
		
		return r; 
	}

	public Results getResults(String query) throws SQLException { // caught in
																	// Controller
		result = null;
		Results results = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<String> columns = new ArrayList<>();
		List<List<String>> rows = new ArrayList<>();
		try {
			Class.forName(DRIVER_CLASS_NAME);
			conn = DriverManager.getConnection(URL, username, password);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			ResultSetMetaData rsmd = rs.getMetaData();
			System.out.println(rsmd.getColumnCount());
			System.out.print("cols: ");

			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				System.out.print(rsmd.getColumnLabel(i) + " ");
				columns.add(rsmd.getColumnLabel(i));
			}

			while (rs.next()) {
				List<String> row = new ArrayList<>();

				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					row.add(rs.getString(i));
				}
				rows.add(row);
			}
			results = new Results(columns, rows);
			for (String col : columns) {
				System.out.print(col + "\t");
			}
			for (List<String> strings : rows) {
				System.out.println();
				for (String thing : strings) {
					System.out.print(thing + "\t");
				}
			}

			// } catch (SQLException e) {
			// // TODO: handle exception
			// System.out.println("THERE WAS A PROBLEM WITH SQL");
			// //now caught by the @ExceptionHandler thing in the Controller
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (stmt != null) {
					conn.close();
				}
				System.out.println("ResultSet, Statement, and Connection closed.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return results;
	}

	public Results updateDatabase(String dml) throws SQLException{
		result = null;
		Results results = null;
		Connection conn = null;
		Statement stmt = null;
		int rs = 0;
		try {
			Class.forName(DRIVER_CLASS_NAME);
			conn = DriverManager.getConnection(URL, username, password);
			stmt = conn.createStatement();
			rs = stmt.executeUpdate(dml);
			results = new Results(rs);
			System.out.println("R0ws affected: " + rs);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				
				if (stmt != null) {
					stmt.close();
				}
				if (stmt != null) {
					conn.close();
				}
				System.out.println("Statement, and Connection closed.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return results;
		
	}
	
}
