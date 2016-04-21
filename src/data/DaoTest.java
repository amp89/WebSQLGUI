package data;

import java.sql.SQLException;

public class DaoTest {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		DBDAO dao = new DBDAO();
		try{
			/*
			 * test add statment
			 */
//		dao.getResults("SELECT id, firstname"+ " FROM employees");
		
//			dao.doQuery("SELECT id, firstname, salary FROM employees");
//			dao.doQuery("UPDATE TABLE employees SET salary = 9999999 WHERE id=100007");
//			dao.updateDatabase("UPDATE employees SET salary = 99999 WHERE id = 100007");
//			dao.updateDatabase("UPDATE employees SET zipcode = 99999 WHERE id = 100007");
//			dao.updateDatabase("INSERT INTO employees (id,firstname,lastname,job_id,department_id) VALUES (99124,'WTF','AHHHAHAHHHHHHHAHAH',3,3)");
//			dao.doQuery("INSERT INTO employees (id,firstname,lastname,job_id,department_id) VALUES (99129,'WTF','AHHHAHAHHHHHHHAHAH',3,3)");
			dao.doQuery("desc employees");
			/*
		 * 
		 */
		
		
		}catch(SQLException e){
//			e.printStackTrace();
			System.out.println(e);
			System.out.println("SQL PROBLEM, YOU ARE A STUPID IDIOT");
			System.out.println("STOP BEING SUCH AN IDIOT");
		}

	}

}
