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
	
	public static void displayUserMenu() 
	{
		clearConsole();
		System.out.println("*********************** User Menu ***********************");
		System.out.println("* 1. Apply Claim					*");
		System.out.println("* 2. Edit Claim     					*");
		System.out.println("* 3. Cancel Claim					*");
		System.out.println("* 3. Approve Claim					*");
		System.out.println("* 4. Back To Main Menu                            	*");
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
	
	public static void mainMenuView()
	{
		Scanner input = new Scanner(System.in);
		displayMainMenu();
		
		int choice = input.nextInt(); 
		
		switch(choice)
		{
			case 1: adminMenuView();
			case 2: userClaimView();
		}
		input.close();
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
			case 4: mainMenuView();
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
	
	public static void userClaimView()
	{
		Scanner input = new Scanner(System.in);
		displayUserMenu();
		
		int choice = input.nextInt(); 
		
		switch(choice)
		{
			case 1: applyUserClaim();
			case 2: editUserClaim();
			case 3: cancelUserClaim();
			case 4: approveUserClaim();
			case 5: mainMenuView();
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
			case 1: addClaim();
			case 2: editClaim();
			case 3: deleteClaim();
			case 4: viewClaim();
			case 5: searchClaim();
			case 6: adminMenuView();
		}
		input.close();
	}
	
	// Employee (Admin)
	
	public static void addEmployee()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter employee id :");
		String empID = input.nextLine();
	}
	
	public static void editEmployee()
	{
		
	}
	
	public static void deleteEmployee()
	{
		
	}
	
	public static void viewEmployee()
	{
		
	}
	
	public static void searchEmployee()
	{
		
	}

	// Claim Type (Admin)
	
	public static void addClaimType()
	{
		
	}
	
	public static void editClaimType()
	{
		
	}
	
	public static void deleteClaimType()
	{
		
	}
	
	public static void viewClaimType()
	{
		
	}
	
	public static void searchClaimType()
	{
		
	}
	
	// Claim (Admin)
	
	public static void addClaim()
	{
		
	}
	
	public static void editClaim()
	{
		
	}
	
	public static void deleteClaim()
	{
		
	}
	
	public static void viewClaim()
	{
		
	}
	
	public static void searchClaim()
	{
		
	}

	// Claim (User)
	
	public static void applyUserClaim()
	{
		
	}
	
	public static void editUserClaim()
	{
		
	}
	
	public static void cancelUserClaim()
	{
		
	}
	
	public static void approveUserClaim()
	{
		
	}

	public static void main(String[] args) 
	{
		 mainMenuView();
	}
}