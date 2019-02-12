package control;

import java.util.*;
import java.sql.*;
import database.Dbh;

import record.Employee;

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
			
			System.out.println("*********************** Login ***********************");
			
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
								empInfo.SetPassword(pw);
								System.out.println("Password correct.");
								pflag = 0;	
								break;
							}
							else {
								System.out.println("Password incorrect. Please enter again.");
								pflag = 1;
							}
						}
					}while(pflag == 1);
				}
			}while(eflag == 0);
			
			db.closeConnection();
			input.close();
		}catch(Exception e) {
			e.printStackTrace();
		}

		}
	
	public void setEmployee() {
		
	}
	public static void main (String[] args) {
		Main main = new Main();
	}

}
