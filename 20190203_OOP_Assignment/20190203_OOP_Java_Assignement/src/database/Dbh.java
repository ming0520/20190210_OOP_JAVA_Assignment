package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * Database connection
 */
public class Dbh {

	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	private String sDriver = "com.mysql.jdbc.Driver";
	
	private static final String host = "jdbc:mysql://localhost:3306/ims_test?useTimezone=true&serverTimezone=UTC";
	private static final String userName = "root";
	private static final String password = "";
	
	public void connect() throws SQLException, Exception{
			Class.forName(this.sDriver); 
			this.conn = DriverManager.getConnection(Dbh.host, Dbh.userName, Dbh.password);
			this.stmt = conn.createStatement();
			System.out.println("Connected!");
	}
	
	public void closeConnection () throws SQLException, Exception{
		this.stmt.close();
		this.conn.close();
	}
	
	public Statement getStatement() {
		return this.stmt;
	}
	
	public Connection getConnection() {
		return this.conn;
	}
}
