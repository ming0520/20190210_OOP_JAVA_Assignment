package control;

import java.util.*;
import java.sql.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			int pflag = 0, eflag = 0;
			
			Scanner input = new Scanner(System.in);
			
			Class.forName("com.mysql.jdbc.Driver"); 
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/ims?useTimezone=true&serverTimezone=UTC", "root", "");
			Statement stmt = conn.createStatement();
			
			System.out.println("\tLOGIN");
			System.out.println("--------------------");
			
			do {
				System.out.print("Enter your employee ID: ");
				
				String id = input.nextLine();
				
				ResultSet rs = stmt.executeQuery("SELECT empID FROM empdetails");
				while(rs.next()) {
					String empID = rs.getString("empID");
					if(id.equals(empID)) {
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

						rs = stmt.executeQuery("SELECT pass,empID FROM empdetails WHERE empID = '" + id + "'");
						
						while(rs.next()) {
							String pass = rs.getString("pass");
							if(pw.equals(pass)) {
								System.out.println("Password correct.");
								pflag = 0;	
								System.out.println();
								//Administrator.Ad();
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
			
			input.close();	
			conn.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}

		}

}
