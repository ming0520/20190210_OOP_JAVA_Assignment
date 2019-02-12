package control;

import java.util.Scanner;

public class Admin
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
	
	public static void displayMainMenu()
	{
		clearConsole();
		System.out.println("*********************** Main Menu ***********************");
		System.out.println("* 1. Admin Menu						*");
		System.out.println("* 2. User Menu						*");
		System.out.println("* Enter the number and press <enter> to continue	*");
		System.out.println("*********************************************************");	
	}
	
	public static void displayAdminMenu() 
	{
		clearConsole();
		System.out.println("********************** Admin Menu ***********************");
		System.out.println("* 1. Employee Record					*");
		System.out.println("* 2. Claim Type Record					*");
		System.out.println("* 3. Claim Record					*");
		System.out.println("* 4. Back To Main Menu              			*");
		System.out.println("* Enter the number and press <enter> to continue	*");
		System.out.println("*********************************************************");	
	}
	
	public static void displayEmployeeMenu()
	{	
		clearConsole();
		System.out.println("********************* Employee Menu *********************");
		System.out.println("* 1. Add Employee					*");
		System.out.println("* 2. Edit Employee					*");
		System.out.println("* 3. Delete Employee					*");
		System.out.println("* 4. View Employee					*");
		System.out.println("* 5. Search Employee					*");
		System.out.println("* 6. Back to Admin Menu					*");
		System.out.println("* Enter the number and press <enter> to continue	*");
		System.out.println("*********************************************************");		
	}
	
	public static void displayClaimMenu()
	{
		clearConsole();
		System.out.println("********************* Claim Menu ************************");
		System.out.println("* 1. Add Claim						*");
		System.out.println("* 2. Edit Claim						*");
		System.out.println("* 3. Delete Claim					*");
		System.out.println("* 4. View Claim						*");
		System.out.println("* 5. Search Claim					*");
		System.out.println("* 6. Back to Admin Menu					*");
		System.out.println("* Enter the number and press <enter> to continue	*");
		System.out.println("*********************************************************");
		
	}
	
	public static void displayClaimTypeMenu()
	{
		clearConsole();
		System.out.println("******************** Claim Type Menu ********************");
		System.out.println("* 1. Add Claim Type					*");
		System.out.println("* 2. Edit Claim Type					*");
		System.out.println("* 3. Delete Claim Type					*");
		System.out.println("* 4. View Claim Type					*");
		System.out.println("* 5. Search Claim Type					*");
		System.out.println("* 6. Back to Admin Menu					*");
		System.out.println("* Enter the number and press <enter> to continue	*");
		System.out.println("*********************************************************");
	}
	
	public static void adminMenuView()
	{
		Scanner input = new Scanner(System.in);
		displayAdminMenu();
		
		int choice = input.nextInt(); 
		
		switch(choice)
		{
			case 1: adminEmployeeView();
			case 2: adminClaimTypeView();
			case 3: adminClaimView();
			//case 4: User.userClaimView();
		}
		input.close();
	}
	
	public static void adminEmployeeView()
	{
		Scanner input = new Scanner(System.in);
		displayEmployeeMenu();
		
		int choice = input.nextInt(); 
		
		switch(choice)
		{
			case 1: addEmployee();
			case 2: editEmployee();
			case 3: deleteEmployee();
			case 4: viewEmployee();
			case 5: searchEmployee();
			case 6: adminMenuView();
		}
		input.close();
	}
	
	public static void adminClaimTypeView()
	{
		Scanner input = new Scanner(System.in);
		displayClaimTypeMenu();
		
		int choice = input.nextInt(); 
		
		switch(choice)
		{
			case 1: addClaimType();
			case 2: editClaimType();
			case 3: deleteClaimType();
			case 4: viewClaimType();
			case 5: searchClaimType();
			case 6: adminMenuView();
		}
		input.close();
	}
	
	public static void adminClaimView()
	{
		Scanner input = new Scanner(System.in);
		displayClaimMenu();
		
		int choice = input.nextInt(); 
		
		switch(choice)
		{
			case 1: applyClaim();
			case 2: editClaim();
			case 3: cancelClaim();
			case 4: approveClaim();
			case 5: displayClaim();
			case 6: adminMenuView();
		}
		input.close();
	}
	
	// Employee
	
	public static void addEmployee()
	{
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("Employee's Name: ");
		String name = input.nextLine();
		System.out.println("Employee's Password: ");
		String password = input.nextLine();
		System.out.println("Employee's Department: ");
		String department = input.nextLine();
		System.out.println("Employee's Position: ");
		String position = input.nextLine();
		
		
		
		adminEmployeeView();
		input.close();
	}
	
	public static void editEmployee()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Employee's ID: ");
		String empID = input.nextLine();
		System.out.println("Employee's Password: ");
		String password = input.nextLine();
		
		System.out.println("New Employee's Department: ");
		String department = input.nextLine();
		System.out.println("New Employee's Position: ");
		String position = input.nextLine();
		
		
		
		adminEmployeeView();
		input.close();
	}
	
	public static void deleteEmployee()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Employee's ID: ");
		String empID = input.nextLine();
		
		
		
		adminEmployeeView();
		input.close();
	}
	
	public static void viewEmployee()
	{
		
		
		
		adminEmployeeView();
	}
	
	public static void searchEmployee()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Employee's ID: ");
		String empID = input.nextLine();
		
		
		
		adminEmployeeView();
		input.close();
	}

	// Claim Type
	
	public static void addClaimType()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Claim Type ID: ");
		String claimTypeID = input.nextLine();
		System.out.println("Claim Type Name: ");
		String claimTypeName = input.nextLine();
		System.out.println("Position: ");
		String applicableToPosition = input.nextLine();
		System.out.println("Limit: ");
		float limit = input.nextFloat();
		
		
		adminClaimTypeView();
		input.close();
	}
	
	public static void editClaimType()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Claim Type ID: ");
		String claimTypeID = input.nextLine();
		
		System.out.println("New Position: ");
		String applicableToPosition = input.nextLine();
		System.out.println("New Limit: ");
		float limit = input.nextFloat();
		
		
		
		adminClaimTypeView();
		input.close();
	}
	
	public static void deleteClaimType()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Claim Type ID: ");
		String claimTypeID = input.nextLine();
		
		
		
		adminClaimTypeView();
		input.close();
	}
	
	public static void viewClaimType()
	{
		
		
		
		adminClaimTypeView();
	}
	
	public static void searchClaimType()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Claim Type ID: ");
		String claimTypeID = input.nextLine();
		
		
		
		adminClaimTypeView();
		input.close();
	}
	
	// Claim
	
	public static void applyClaim()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Employee's ID: ");
		String empID = input.nextLine();
		System.out.println("Claim ID: ");
		String claimID = input.nextLine();
		System.out.println("Claim Type ID: ");
		String claimTypeID = input.nextLine();
		System.out.println("Date: ");
		String date = input.nextLine();
		System.out.println("Amount: ");
		float amount = input.nextFloat();
		System.out.println("Remark: ");
		String remark = input.nextLine();
		System.out.println("Approver ID: ");
		String approverID = input.nextLine();
		System.out.println("Status:");
		String status = input.nextLine();
		System.out.println("Remark: ");
		String decisionRemark = input.nextLine();
		

		
		adminClaimView();
		input.close();
	}
	
	public static void editClaim()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Employee's ID: ");
		String empID = input.nextLine();
		System.out.println("Claim ID: ");
		String claimID = input.nextLine();
		
		System.out.println("New Amount: ");
		float amount = input.nextFloat();
		System.out.println("New Remark: ");
		String remark = input.nextLine();
		
		
		
		adminClaimView();
		input.close();
	}
	
	public static void approveClaim()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Claim ID: ");
		String claimID = input.nextLine();
		
		System.out.println("New Status: ");
		String status = input.nextLine();
		System.out.println("New Remark: ");
		String decisionRemark = input.nextLine();
		
		
		
		adminClaimView();
		input.close();
	}
	
	public static void cancelClaim()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Employee's ID: ");
		String empID = input.nextLine();
		System.out.println("Claim ID: ");
		String claimID = input.nextLine();
		
		
		
		adminClaimView();
		input.close();
	}
	
	public static void displayClaim()
	{
		
		
		
		
		adminClaimView();
	}
}