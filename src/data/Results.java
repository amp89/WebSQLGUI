package data;

import java.util.List;

public class Results {
	List<String> columns;
	List<List<String>> rows;
	int rowsAffected;
	
	
	
	public Results(int numResults){
		this.rowsAffected = numResults;
	}
	
	public Results(List<String> columns, List<List<String>> rows) {
		super();
		this.columns = columns;
		this.rows = rows;
	}
	public List<String> getColumns() {
		return columns;
	}
	public void setColumns(List<String> columns) {
		this.columns = columns;
	}
	public List<List<String>> getRows() {
		return rows;
	}
	public void setRows(List<List<String>> rows) {
		this.rows = rows;
	}
	public int getRowsAffected() {
		return rowsAffected;
	}
	public void setRowsAffected(int rowsAffected) {
		this.rowsAffected = rowsAffected;
	}
	
}
