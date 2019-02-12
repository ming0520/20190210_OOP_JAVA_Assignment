package control;

import java.util.*;
import java.sql.*;

import database.Dbh;

import record.Employee.Status;
import record.Employee.UserRole;
import record.Employee;

import control.Admin;
import control.User;


public class Main{
	private static Employee empInfo;
	
	public Main() {
		empInfo = new Employee();
		Dbh db = new Dbh();
		// TODO Auto-generated method stub
		try {
			
			int pflag = 0, eflag = 0;
			db.connect();
			Scanner input = new Scanner(System.in);
			
			System.out.println("=================================================================");
			System.out.println("                              Login");
			System.out.println("-----------------------------------------------------------------");
			
			do {
				System.out.print("Enter your employee ID: ");
				
				String id = input.nextLine();
				ResultSet rs = db.getStatement().executeQuery("SELECT empID FROM empdetails");
				while(rs.next()) {
					String empID = rs.getString("empID");
					if(id.equals(empID)) {
						Main.empInfo.SetEmpID(id);
						eflag = 1;
						break;
					}
				}
				if(eflag == 0) {
					System.out.println("Employee profile doesn't exist. Please enter again.");
				}
				else {
					do {
						System.out.print("Enter your password: ");
						String pw = input.nextLine();
						
						PreparedStatement getPassword = db.getConnection().prepareStatement("SELECT pass,"
								+ "empID FROM empdetails WHERE empID = ?");
						
						getPassword.setString(1, id);
						
						rs = getPassword.executeQuery();
//						rs = stmt.executeQuery("SELECT pass,empID FROM empdetails WHERE empID = '" + id + "'");
						
						while(rs.next()) {
							String pass = rs.getString("pass");
							if(pw.equals(pass)) {

								System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
										+ "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
								Main.empInfo.SetPassword(pw);
								System.out.println("Password correct.");
								this.setEmployee();
								pflag = 0;	
								break;
							}
							else {
								System.out.println("Password incorrect. Please enter again.");
								pflag = 1;
							}
						}
						rs.close();
					}while(pflag == 1);
				}
			}while(eflag == 0);
			
			db.closeConnection();
			input.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

		}
	
	public void setEmployee (){
		Dbh db = new Dbh();
		String selectSql = "SELECT * FROM empdetails WHERE empID = ?";
		try {
			db.connect();
			PreparedStatement stmt = db.getConnection().prepareStatement(selectSql);
			stmt.setString(1, Main.empInfo.GetEmpID());
			
			ResultSet rs;
			rs = stmt.executeQuery();
			
			
			while(rs.next()) {
				Main.empInfo.SetEmpID(rs.getString("empID"));
				Main.empInfo.SetPassword(rs.getString("pass"));
				Main.empInfo.SetName(rs.getString("name"));
				Main.empInfo.SetDepartment(rs.getString("department"));
				Main.empInfo.SetPosition(rs.getString("position"));
				
				UserRole userRole;
				switch(rs.getString("userRole")) {
					case "ADMIN" :
						userRole = UserRole.ADMIN;
						break;
					case "USER" :
						userRole = UserRole.USER;
						break;
					default:
						userRole = UserRole.USER;
				}
				
				Main.empInfo.SetUserRole(userRole);
				
				Status status;
				
				switch (rs.getString("stat")) {
					case "ACTIVE":
						status = Status.ACTIVE;
						break;
					case "INACTIVE" :
						status = Status.INACTIVE;
						break;
					default:
						status = Status.INACTIVE;
				}
				
				Main.empInfo.SetStatus(status);
				Main.empInfo.SetSuperiorID(rs.getString("superiorID"));
				System.out.println("Setting profile...");
				Main.empInfo.displayEmployee();
				System.out.println("Done!");
				this.determineMenu();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	public void determineMenu() {
		switch(Main.empInfo.GetUserRole()) {
			case ADMIN:
				Admin.adminMenuView();
				break;
			case USER:
				User.displayUserMenu();
				break;				
		default:
			Main main = new Main();
			break; 
		}
	}
	public static void main (String[] args) {
		Main main = new Main();
	}

}
