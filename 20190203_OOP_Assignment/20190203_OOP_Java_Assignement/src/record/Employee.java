package record;

import database.Dbh;
import record.Employee.Status;
import record.Employee.UserRole;

import java.sql.ResultSet;

import control.Main;

import java.sql.PreparedStatement;

public class Employee extends Dbh
{
	private String empID;
	private String password;
	private String name;
	private String department;
	private String position;
	private UserRole userRole;
	private Status status;
	private String superiorID;
	
	public enum UserRole
	{
		ADMIN,
		USER;
	}
	public enum Status
	{
		ACTIVE,
		INACTIVE;
	}
	
	public Employee()
	{
		
	}
	
	public Employee(String name, String password)
	{
		this.name = name;
		this.password = password;
	}
	
	public Employee(String empID)
	{
		this.empID = empID;
	}
	
	public Employee(String empID, String password, String name,String department, String position, UserRole userRole, Status status, String superiorID)
	{
		this.empID = empID;
		this.password = password;
		this.name = name;
		this.department = department;
		this.position = position;
		this.userRole = userRole;
		this.status = status;
		this.superiorID = superiorID;
	}
	
	public void SetEmpID(String empID) 
	{
		this.empID = empID;
	}
	
	public String GetEmpID()
	{
		return this.empID;
	}
	
	public void SetPassword(String password) 
	{
		this.password = password;
	}
	
	public String GetPassword()
	{
		return this.password;
	}
	
	public void SetName(String name) 
	{
		this.name = name;
	}
	
	public String GetName()
	{
		return this.name;
	}
	
	public void SetDepartment(String department) 
	{
		this.department = department;
	}
	
	public String GetDepatment()
	{
		return this.department;
	}
	
	public void SetPosition(String position) 
	{
		this.position = position;
	}
	
	public String GetPosition()
	{
		return this.position;
	}
	
	public void SetStatus(Status status) 
	{
		this.status = status;
	}
	
	public Status GetStatus()
	{
		return this.status;
	}
	
	public void SetUserRole(UserRole userRole)
	{
		this.userRole = userRole;
	}
	
	public UserRole GetUserRole()
	{
		return this.userRole;
	}
	
	public void SetSuperiorID(String superiorID) 
	{
		this.superiorID = superiorID;
	}
	
	public String GetSuperiorID()
	{
		return superiorID;
	}
	
	public void displayEmployee() {
		System.out.println("=================================================================");
		System.out.println("                       Employee Profile");
		System.out.println("-----------------------------------------------------------------");
		System.out.println("ID		:\t" + this.GetEmpID());
		System.out.println("Name		:\t" + this.GetName());
		System.out.println("Department	:\t" + this.GetDepatment());
		System.out.println("Position	:\t" + this.GetPosition());
		System.out.println("Status		:\t" + this.GetStatus().toString());
		System.out.println("Role		:\t"+this.GetUserRole().toString());
		System.out.println("Superior ID 	:\t"+ this.GetSuperiorID());
		System.out.println("=================================================================");
	}
	
	public Employee getEmployeeObj() {
		Employee newEmp = new Employee();
		 newEmp.SetDepartment(this.department);
		 newEmp.SetEmpID(this.empID);
		 newEmp.SetName(this.name);
		 newEmp.SetPassword(this.password);
		 newEmp.SetPosition(this.position);
		 newEmp.SetStatus(this.status);
		 newEmp.SetSuperiorID(this.superiorID);
		 newEmp.SetUserRole(this.userRole);
		return newEmp;
		 
	}
	
	public void getEmployee(String sql) {
		try {
			this.connect();
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				this.SetEmpID(rs.getString("empID"));
				this.SetPassword(rs.getString("pass"));
				this.SetName(rs.getString("name"));
				this.SetDepartment(rs.getString("department"));
				this.SetPosition(rs.getString("position"));
				
				UserRole userRole;
				switch(rs.getString("userRole")) 
				{
					case "ADMIN" :
						userRole = UserRole.ADMIN;
						break;
					case "USER" :
						userRole = UserRole.USER;
						break;
					default:
						userRole = UserRole.USER;
				}
				
				this.SetUserRole(userRole);
				
				Status status;
				
				switch (rs.getString("stat"))
				{
					case "ACTIVE":
						status = Status.ACTIVE;
						break;
					case "INACTIVE" :
						status = Status.INACTIVE;
						break;
					default:
						status = Status.INACTIVE;
				}
				
				this.SetStatus(status);
				this.SetSuperiorID(rs.getString("superiorID"));
				this.displayEmployee();
				
			}
			
			rs.close();
			this.closeConnection();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean addEmployee() {
		String SelectSql = "SELECT empID FROM empdetails WHERE empID = ?";
		String InsertSql = "INSERT INTO `empdetails` (`empID`, `pass`, `name`, `department`, `position`, `userRole`, `stat`, `superiorID`) "
				+ "VALUES\n" + 
				"(?, ?,?, ?, ?, ?, ?, ?)";
		Dbh db = new Dbh();
		
		try {
			db.connect();
			
			PreparedStatement selectEmp = db.getConnection().prepareStatement(SelectSql);
			selectEmp.setString(1, this.GetEmpID());
			ResultSet rs = selectEmp.executeQuery();
			
			int counter = 0;
			while(rs.next()) {
				counter++;
			}
			
			if(counter > 0) {
				System.out.println("The employee ID existed, please try again!");
				
				selectEmp.close();
				rs.close();
				db.closeConnection();
				
				return false;
			}else {
				System.out.println("Adding...");
				PreparedStatement insertEmp = db.getConnection().prepareStatement(InsertSql);
				insertEmp.setString(1, this.GetEmpID());
				insertEmp.setString(2, this.GetPassword());
				insertEmp.setString(3, this.GetName());
				insertEmp.setString(4, this.GetDepatment());
				insertEmp.setString(5, this.GetPosition());
				insertEmp.setString(6, this.GetUserRole().toString());
				insertEmp.setString(7, this.GetStatus().toString());
				insertEmp.setString(8, this.GetSuperiorID());
				insertEmp.executeUpdate();
				System.out.println("Added successfully!");
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean editEmployee() {
		
		String selectSql = "SELECT empID FROM empdetails WHERE empID = ?";
		String insertSql = "UPDATE empdetails SET "
				+ "pass=?, "
				+ "department=?, position=? "
				+ "WHERE empID=?";
		
		Dbh db = new Dbh();
		
		try {
			db.connect();
			PreparedStatement stmt;
			ResultSet rs;
			
			stmt = db.getConnection().prepareStatement(selectSql);
			stmt.setString(1, this.empID);
			
			rs = stmt.executeQuery();
			rs.last();
			int rowCount = rs.getRow();
			
			if(!(rowCount > 0)) {
				System.out.println("The employee does not exist, please try again!");
				
				rs.close();
				stmt.close();
				db.closeConnection();
				
				return false;
			}
			else {
				System.out.println("Editing...");
				stmt = db.getConnection().prepareStatement(insertSql);
				stmt.setString(1, this.GetPassword());
				stmt.setString(2, this.GetDepatment());	
				stmt.setString(3, this.GetPosition());
				stmt.setString(4, this.GetEmpID());
				stmt.executeUpdate();
				System.out.println("Edited sucessfully!");
				rs.close();
				stmt.close();
				db.closeConnection();
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean deleteEmployee() {
		String selectSql = "SELECT * FROM empdetails WHERE empID=?";
		String deleteSql = "DELETE FROM empdetails WHERE empID=?";
		
		PreparedStatement stmt;
		ResultSet rs;
		Dbh db = new Dbh();
		
		try {
			db.connect();
			
			stmt = db.getConnection().prepareStatement(selectSql);
			stmt.setString(1, this.GetEmpID());
			rs = stmt.executeQuery();
			rs.last();
			
			if(rs.getRow() > 0) {
				System.out.println("Deleting...");
				stmt = db.getConnection().prepareStatement(deleteSql);
				stmt.setString(1,this.GetEmpID());
				stmt.executeUpdate();
				rs.close();
				stmt.close();
				db.closeConnection();
				System.out.println("Deleted successfully!");
				return true;
			}else {
				System.out.println("The employee does not exist, please try again!");
				rs.close();
				stmt.close();
				db.closeConnection();
				return false;
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
//	public boolean addEmployee(Employee newEmp) {
//		String SelectSql = "SELECT empID FROM empdetails WHERE empID = ?";
//		String InsertSql = "INSERT INTO `empdetails` (`empID`, `pass`, `name`, `department`, `position`, `userRole`, `stat`, `superiorID`) "
//				+ "VALUES\n" + 
//				"(?, ?,?, ?, ?, ?, ?, ?)";
//		Dbh db = new Dbh();
//		
//		try {
//			db.connect();
//			
//			PreparedStatement selectEmp = db.getConnection().prepareStatement(SelectSql);
//			selectEmp.setString(1, newEmp.GetEmpID());
//			ResultSet rs = selectEmp.executeQuery();
//			
//			if(rs.getRow() > 0) {
//				System.out.println("The employee ID existed! Please try again!");
//				
//				selectEmp.close();
//				rs.close();
//				db.closeConnection();
//				
//				return false;
//			}else {
//				
//				PreparedStatement insertEmp = db.getConnection().prepareStatement(InsertSql);
//				insertEmp.setString(1, newEmp.GetEmpID());
//				insertEmp.setString(2, newEmp.GetPassword());
//				insertEmp.setString(3, newEmp.GetName());
//				insertEmp.setString(4, newEmp.GetDepatment());
//				insertEmp.setString(5, newEmp.GetPosition());
//				insertEmp.setString(6, newEmp.GetUserRole().toString());
//				insertEmp.setString(7, newEmp.GetStatus().toString());
//				insertEmp.setString(8, newEmp.GetSuperiorID());
//				
//				try {
//					insertEmp.executeUpdate();
//				}catch(Exception e) {
//					e.getMessage();
//				}
//				
//			}
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return false;
//	}
	
}
