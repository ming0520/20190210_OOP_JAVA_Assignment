package control;

import java.sql.*;
import java.util.NoSuchElementException;
import java.util.Scanner;
import record.Employee;
import record.ClaimType;
import control.User;

import database.Dbh;

public class Admin extends Dbh
{
	public final static void clearConsole()
	{
	    try
	    {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	        {
	            Runtime.getRuntime().exec("cls");
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e)
	    {
	        //  Handle any exceptions.
	    }
	    
	}
/*
 * 
 * Title : All the menu layout for Admin Operation
 * Function : Display the particular menu to the user
 * Return : void
 *  
 */

	public static void main(String[] args) {
		adminMenuView();
	}
	
	public static void displayAdminMenu() 
	{
		System.out.println("=================================================================");
		System.out.println("                       Admin Menu                               ");
		System.out.println("-----------------------------------------------------------------");
		System.out.println(" 1. Employee Record                                            ");
		System.out.println(" 2. Claim Type Record                                          ");
		System.out.println(" 3. Claim Record                                               ");
//		System.out.println(" 4. Back To Main Menu                                          ");
		System.out.println(" Enter the number and press <enter> to continue                ");
		System.out.println("=================================================================");	
	}
	
	public static void displayEmployeeMenu()
	{	
		clearConsole();
		System.out.println("=================================================================");
		System.out.println("                       Employee Record                          ");
		System.out.println("-----------------------------------------------------------------");
		System.out.println(" 1. Add Employee                                               ");
		System.out.println(" 2. Edit Employee                                              ");
		System.out.println(" 3. Delete Employee                                            ");
		System.out.println(" 4. View Employee                                              ");
		System.out.println(" 5. Search Employee                                            ");
		System.out.println(" 6. Back to Admin Menu                                         ");
		System.out.println(" Enter the number and press <enter> to continue                ");
		System.out.println("=================================================================");			
	}
	
	public static void displayClaimMenu()
	{
		clearConsole();
		System.out.println("=================================================================");
		System.out.println("                       Claim Menu                               ");
		System.out.println("-----------------------------------------------------------------");
		System.out.println(" 1. Apply Claim                                                ");
		System.out.println(" 2. Edit Claim                                                 ");
		System.out.println(" 3. Cancel Claim                                               ");
		System.out.println(" 4. Approve Claim                                              ");
		System.out.println(" 5. Display Claim                                              ");
		System.out.println(" 6. Back to Admin Menu                                         ");
		System.out.println(" Enter the number and press <enter> to continue	            ");
		System.out.println("=================================================================");	
		
	}
	
	public static void displayClaimTypeMenu()
	{
		clearConsole();
		System.out.println("=================================================================");
		System.out.println("                       Claim Type Menu                          ");
		System.out.println("-----------------------------------------------------------------");
		System.out.println(" 1. Add Claim Type                                            ");
		System.out.println(" 2. Edit Claim Type                                            ");
		System.out.println(" 3. Delete Claim Type                                          ");
		System.out.println(" 4. View Claim Type                                            ");
		System.out.println(" 5. Search Claim Type                                          ");
		System.out.println(" 6. Back to Admin Menu                                         ");
		System.out.println(" Enter the number and press <enter> to continue                ");
		System.out.println("=================================================================");	
	}


//	/*
//	 * Title : Call out the menu
//	 * Function : Display the specify menu with specify operation
//	 * Return : void
//	 *  
//	 */
	public static void adminMenuView()
	{	
		Scanner input = new Scanner(System.in);
		displayAdminMenu();
		
		int choice = 0;
		System.out.print("Enter Choice: ");
		
		while(true) 
		{
		    try 
		    {
		         choice = Integer.parseInt(input.nextLine());
		         
		         if (choice > 0 && choice <= 4)
		         {
		              break;
		         }
		         else
		         {
		        	 System.out.print("Invalid choice! Please try again:");
		         }
		    } 
		    catch (NumberFormatException e) 
		    {
		    	System.out.print("Invalid choice! Please try again:");
		    }
		}
		
		switch(choice)
		{
			case 1: adminEmployeeView();break;
			case 2: adminClaimTypeView();break;
			case 3: adminClaimView();break;
			
		}
		
	}
	
	public static void adminEmployeeView()
	{
		Scanner input = new Scanner(System.in);
		displayEmployeeMenu();
		
		int choice = 0;
		System.out.print("Enter choice: ");
		
		while(true) 
		{
		    try 
		    {
		         choice = Integer.parseInt(input.nextLine());
		         
		         if (choice > 0 && choice <= 6)
		         {
		              break;
		         }
		         else
		         {
		        	 System.out.print("Invalid choice! Please try again:");
		         }
		    } 
		    catch (NumberFormatException e) 
		    {
		    	System.out.print("Invalid choice! Please try again:");
		    }
		    catch(NoSuchElementException nsee) {
		    	System.out.println("Enter choice: ");
		    }
		} 
		
		switch(choice)
		{
			case 1: addEmployee();
			case 2: editEmployee();
			case 3: deleteEmployee();
			case 4: viewEmployee();
			case 5: searchEmployee();
			case 6: adminMenuView();
		}
		
	}

	
	public static void adminClaimTypeView()
	{
		Scanner input = new Scanner(System.in);
		displayClaimTypeMenu();
		
		int choice = 0;
		System.out.print("Enter Choice: ");
		
		while(true) 
		{
		    try 
		    {
		         choice = Integer.parseInt(input.nextLine());
		         
		         if (choice > 0 && choice <= 6)
		         {
		              break;
		         }
		         else
		         {
		        	 System.out.print("Invalid choice! Please try again:");
		         }
		    } 
		    catch (NumberFormatException e) 
		    {
		    	System.out.print("Invalid choice! Please try again:");
		    }
		}  
		
		switch(choice)
		{
			case 1: addClaimType();
			case 2: editClaimType();
			case 3: deleteClaimType();
			case 4: viewClaimType();
			case 5: searchClaimType();
			case 6: adminMenuView();
		}
		
	}
	
	public static void adminClaimView()
	{
		Scanner input = new Scanner(System.in);
		displayClaimMenu();
		
		int choice = 0;
		System.out.print("Enter Choice: ");
		while(true) 
		{
		    try 
		    {
		         choice = Integer.parseInt(input.nextLine());
		         
		         if (choice > 0 && choice <= 6)
		         {
		              break;
		         }
		         else
		         {
		        	 System.out.print("Invalid choice! Please try again:");
		         }
		    } 
		    catch (NumberFormatException e) 
		    {
		    	System.out.print("Invalid choice! Please try again:");
		    }
		}  
		
		switch(choice)
		{
			case 1: applyClaim();
			case 2: editClaim();
			case 3: cancelClaim();
			case 4: approveClaim();
			case 5: displayClaim();
			case 6: adminMenuView();
		}
		
	}
	
//	/*
//	 * Employee record operation
//	 * Get the input from user and process it in database
//	 * Function: Add, Edit, Delete, View, Search Employee and back to previous menu
//	 */
	
	public static void addEmployee()
	{
		Scanner input = new Scanner(System.in);
		
		Employee newEmp = new Employee();
		
		System.out.print("Employee's ID: ");
		newEmp.SetEmpID(input.nextLine());
		System.out.print("Employee's Name: ");
		newEmp.SetName(input.nextLine());
		System.out.print("Employee's Password: ");
		newEmp.SetPassword(input.nextLine());
		System.out.print("Employee's Department: ");
		newEmp.SetDepartment(input.nextLine());
		System.out.print("Employee's Position: ");
		newEmp.SetPosition(input.nextLine());
		
		System.out.println("1 - ACTIVE\t2 - INACTIVE :");
		System.out.print("Employee's status : ");
		
		int statusCode = 0;
		status:
		do {
			statusCode = input.nextInt();
			switch(statusCode) {
				case 1:
					newEmp.SetStatus(Employee.Status.ACTIVE);
					break;
				case 2:
					newEmp.SetStatus(Employee.Status.INACTIVE);
					break;
				default:
					System.out.println("Invlid status! Please try again:");
					continue status;
			}
			
		}while(statusCode < 0);
		
		
		
		System.out.println("1 - ADMIN\t2 - USER");
		System.out.print("Employee's role : ");
		int userRoleCode = 0;
		userRole:
		do {
			userRoleCode = input.nextInt();
			switch(userRoleCode) {
				case 1:
					newEmp.SetUserRole(Employee.UserRole.ADMIN);
					break;
				case 2:
					newEmp.SetUserRole(Employee.UserRole.USER);
					break;
				default:
					System.out.println("Invlid role! Please try again:");
					continue userRole;
			}
			
		}while(userRoleCode < 0);
		
		System.out.print("Employee's superior ID: ");
		input.nextLine();
		newEmp.SetSuperiorID(input.nextLine());
		
		newEmp.addEmployee();
		
		adminEmployeeView();
		
	}
	
	public static void editEmployee()
	{
		Scanner input = new Scanner(System.in);
		Employee empInfo = new Employee();
		Dbh db = new Dbh();
		
		PreparedStatement stmt;
		ResultSet rs;
		boolean isLogin = false;
		int colCout = 0;
		
		try {
			db.connect();
			
			do {
				System.out.print("Employee's ID: ");
				empInfo.SetEmpID(input.nextLine());
				System.out.print("Employee's Password: ");
				empInfo.SetPassword(input.nextLine());

				System.out.println(empInfo.GetEmpID() + "\t" + empInfo.GetPassword());
				
				stmt = db.getConnection().prepareStatement("SELECT * FROM empdetails WHERE empID=? AND pass = ?");
				
				stmt.setString(1, empInfo.GetEmpID().toString());
				stmt.setString(2, empInfo.GetPassword().toString());
				
				rs = stmt.executeQuery();
				rs.last();
				
				if(rs.getRow() > 0) {
					isLogin = true;
				}
				else {
					System.out.println("Incorrect employee id and password");
					isLogin = false;
				}
				
			}while(isLogin == false);
			
			System.out.print("New Employee's Department: ");
			empInfo.SetDepartment(input.nextLine());
			System.out.print("New Employee's Position: ");
			empInfo.SetPosition(input.nextLine());
			
			empInfo.editEmployee();
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
		
		
		adminEmployeeView();
		
	}
	
	public static void deleteEmployee()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Employee's ID: ");
		Employee delEmp = new Employee();
		delEmp.SetEmpID(input.nextLine());
		delEmp.deleteEmployee();
		System.out.println("Press <enter> to continue");
		input.nextLine();
		adminEmployeeView();
		
	}

	public static void viewEmployee()
	{
		
		Scanner input = new Scanner(System.in);
		Employee newEmp = new Employee(); 
		newEmp.getEmployee("SELECT * FROM empdetails WHERE 1");
		System.out.println("Press <enter> to continue...");
		input.nextLine();
		adminEmployeeView();
		
	}
	
	public static void searchEmployee()
	{
		Scanner input = new Scanner(System.in);
		Employee empInfo = new Employee();
		System.out.print("Employee's ID: ");
		empInfo.SetEmpID(input.nextLine());
		System.out.println("Searching...");
		empInfo.getEmployee("SELECT * FROM empdetails WHERE empID = '" + empInfo.GetEmpID().toString() +"'");
		System.out.println("Searched!");
		adminEmployeeView();
		
	}

//	/*
//	 *  Claim Type operation
//	 *  Process the claimtype for database
//	 *  Function : Add,Edit,Delete,View,Search Claim Type in database
//	 */
	
	public static void addClaimType()
	{
		ClaimType newClaimType = new ClaimType();
		Scanner input = new Scanner(System.in);
		boolean existedClaimTypeID = true;
		
		do {
			System.out.print("Claim Type ID: ");
			String claimTypeID = input.nextLine();
			
			Dbh db = new Dbh();
			try {
				
				db.connect();
				PreparedStatement stmt;
				ResultSet rs;
				
				stmt = db.getConnection().prepareStatement("SELECT * FROM claimtype WHERE claimTypeID=?");
				stmt.setString(1, claimTypeID);
				rs = stmt.executeQuery();
				rs.last();
				
				if(rs.getRow() > 0) {
					existedClaimTypeID = true;
					System.out.println("The claim type id existed, please try again!");
					
				}else {
					existedClaimTypeID = false;
					newClaimType.SetClaimTypeID(claimTypeID);

				}
				
				db.closeConnection();
				stmt.close();
				rs.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}while(existedClaimTypeID == true);
		
		
		System.out.print("Claim Type Name: ");
		String claimTypeName = input.nextLine();
		System.out.print("Position: ");
		String applicableToPosition = input.nextLine();
		System.out.print("Limit: ");
		float limit = input.nextFloat();
		
		newClaimType.SetClaimTypeName(claimTypeName);
		newClaimType.SetApplicableToPosition(applicableToPosition);
		newClaimType.SetLimit(limit);
		
		newClaimType.addClaimType();
		
		adminClaimTypeView();
		
	}
	
	public static void editClaimType()
	{
		Scanner input = new Scanner(System.in);
		Dbh db = new Dbh();
		
		PreparedStatement stmt;
		ResultSet rs;
		ClaimType claimType = new ClaimType();
		
		boolean isExisted = true;
		
		String selectSql = "SELECT * FROM claimtype WHERE claimTypeID=?";
		
		do {
			System.out.print("Claim Type ID: ");
			String claimTypeID = input.nextLine();
			
			try {
				db.connect();
				stmt = db.getConnection().prepareStatement(selectSql);
				stmt.setString(1, claimTypeID); 
				rs = stmt.executeQuery();
				rs.last();
				if(rs.getRow() > 0) {
					claimType.SetClaimTypeID(claimTypeID);
					isExisted = true;
				}else {
					System.out.println("The claim id is not exist, please try again:");	
					isExisted = false;
				}
				
				db.closeConnection();
				rs.close();
				stmt.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
				
			
		}while(isExisted == false);
		
		String GCTIDsql = "SELECT * FROM claimtype WHERE claimTypeID = '" 
		+ claimType.GetClaimTypeID() + "'";
		claimType.displayClaimType(GCTIDsql);
		
		System.out.print("New Position: ");
		String applicableToPosition = input.nextLine();
		System.out.print("New Limit: ");
		float limit = input.nextFloat();
		
		claimType.SetApplicableToPosition(applicableToPosition);
		claimType.SetLimit(limit);
		
		claimType.editClaimType();		
		
		adminClaimTypeView();
		
	}
	
	public static void deleteClaimType()
	{
		Scanner input = new Scanner(System.in);
		Dbh db = new Dbh();
		ClaimType claimType = new ClaimType();
		PreparedStatement stmt;
		ResultSet rs;
		
		boolean isExist = false;
		
		do {
			System.out.print("Claim Type ID: ");
			String claimTypeID = input.nextLine();
			claimType.SetClaimTypeID(claimTypeID);
			
			try {
				db.connect();
				stmt = db.getConnection().prepareStatement("SELECT * FROM claimtype WHERE claimTypeID=?");
				stmt.setString(1, claimType.GetClaimTypeID());
				rs = stmt.executeQuery();
				rs.last();
				
				if(rs.getRow() > 0) {
					stmt = db.getConnection().prepareStatement("SELECT * FROM claimrecord WHERE claimTypeId=?");
					stmt.setString(1, claimType.GetClaimTypeID());
					rs = stmt.executeQuery();
					rs.last();
					if(rs.getRow() > 0) {
						System.out.println("The claim type is using in claim record");
						adminClaimTypeView();
					}else {						
						claimType.deleteClaimType();
						isExist = true;
					}
				}else {
					System.out.println("The claim type does not existed, please try again!");
					isExist = false;
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}while(isExist == false);
		
		
		
		adminClaimTypeView();
		
	}
	
	public static void viewClaimType()
	{
		ClaimType claimType = new ClaimType();
		
		claimType.displayClaimType("SELECT * FROM claimtype WHERE 1");
		
		adminClaimTypeView();
	}
	
	public static void searchClaimType()
	{
		Scanner input = new Scanner(System.in);
		Dbh db = new Dbh();
		ClaimType claimType = new ClaimType();
		PreparedStatement stmt;
		ResultSet rs;
		
		boolean isExist = false;
		String selectSql = "SELECT * FROM claimtype WHERE claimTypeID=?";
		do {
			System.out.print("Claim Type ID: ");
			String claimTypeID = input.nextLine();
			
			try {
				claimType.SetClaimTypeID(claimTypeID);
				db.connect();
				stmt = db.getConnection().prepareStatement(selectSql);
				stmt.setString(1, claimType.GetClaimTypeID());
				rs = stmt.executeQuery();
				rs.last();
				
				if(rs.getRow() > 0) {
					isExist = true;
				}else {
					System.out.println("The claim does not exist, please try again!");
					isExist = false;
				}
				db.closeConnection();
				stmt.close();
				rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			
		}while(isExist == false);
		String delSql = "SELECT * FROM claimtype WHERE claimTypeID = '"
				+ claimType.GetClaimTypeID() +"'";
		claimType.displayClaimType(delSql);
		
		adminClaimTypeView();
		
	}
	
//	/*
//	 *  Operation for Claim record
//	 *  Process the claim record on the database
//	 *  Function: apply,edit,approve,cancel,view for the claim record
//	 */
	
	public static void applyClaim()
	{
		Scanner input = new Scanner(System.in);
		User.applyUserClaim();
		System.out.println("Press <enter> to continue... ");
		input.nextLine();
		adminMenuView();
	}
	
	public static void editClaim()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Employee's ID: ");
		String empID = input.nextLine();
		System.out.print("Claim ID: ");
		String claimID = input.nextLine();
		
		System.out.print("New Amount: ");
		float amount = input.nextFloat();
		System.out.print("New Remark: ");
		String remark = input.nextLine();
		
		
		
		adminClaimView();
		
	}
	
	public static void approveClaim()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Claim ID: ");
		String claimID = input.nextLine();
		
		System.out.print("New Status: ");
		String status = input.nextLine();
		System.out.print("New Remark: ");
		String decisionRemark = input.nextLine();
		
		
		
		adminClaimView();
		
	}
	
	public static void cancelClaim()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Employee's ID: ");
		String empID = input.nextLine();
		System.out.print("Claim ID: ");
		String claimID = input.nextLine();
		
		
		
		adminClaimView();
		
	}
	
	public static void displayClaim()
	{
		
		
		
		
		adminClaimView();
	}
}