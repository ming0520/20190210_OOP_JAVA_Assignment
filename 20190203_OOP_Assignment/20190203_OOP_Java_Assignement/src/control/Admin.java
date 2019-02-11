package control;

import java.util.Scanner;

public class Admin {
	
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
	
	public void displayAdminMenu() 
	{
		clearConsole();
		System.out.println("******************** Admin Menu *********************");
		System.out.println("* 1. Employee Record								*");
		System.out.println("* 2. Claim Type Record								*");
		System.out.println("* 3. Claim Record									*");
		System.out.println("* 4. Back To Main Menu                            	*");
		System.out.println("* Enter the number and press <enter> to continue	*");
		System.out.println("*****************************************************");	
	}
	
	
	public void displayEmployeeMenu()
	{	
		clearConsole();
		System.out.println("******************* Employee Menu *******************");
		System.out.println("* 1. Add Employee									*");
		System.out.println("* 2. Edit Employee									*");
		System.out.println("* 3. Delete Employee								*");
		System.out.println("* 4. View Employee									*");
		System.out.println("* 5. Search Employee								*");
		System.out.println("* 6. Back to Admin Menu								*");
		System.out.println("* Enter the number and press <enter> to continue	*");
		System.out.println("*****************************************************");		
	}
	
	public void displayClaimMenu()
	{
		clearConsole();
		System.out.println("******************* Claim Menu **********************");
		System.out.println("* 1. Add Claim										*");
		System.out.println("* 2. Edit Claim										*");
		System.out.println("* 3. Delete Claim									*");
		System.out.println("* 4. View Claim										*");
		System.out.println("* 5. Search Claim									*");
		System.out.println("* 6. Back to Admin Menu								*");
		System.out.println("* Enter the number and press <enter> to continue	*");
		System.out.println("*****************************************************");
		
	}
	
	public void displayClaimTypeMenu()
	{
		clearConsole();
		System.out.println("****************** Claim Type Menu ******************");
		System.out.println("* 1. Add Claim Type									*");
		System.out.println("* 2. Edit Claim Type								*");
		System.out.println("* 3. Delete Claim Type								*");
		System.out.println("* 4. View Claim Type								*");
		System.out.println("* 5. Search Claim Type								*");
		System.out.println("* 6. Back to Admin Menu								*");
		System.out.println("* Enter the number and press <enter> to continue	*");
		System.out.println("*****************************************************");
	}
	
	public void adminMenuView()
	{
		Scanner input = new Scanner(System.in);
		displayAdminMenu();
		
		int choice = input.nextInt(); 
		
		switch(choice)
		{
			case 1: adminEmployeeView();
			case 2: adminClaimTypeView();
			case 3: adminClaimView();
			case 4: ;
		}
		input.close();
	}
	
	public void adminEmployeeView()
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
	
	public void adminClaimTypeView()
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
	
	public void adminClaimView()
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
	
	// Employee
	
	public void addEmployee()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter employee id :");
		String empID = input.nextLine();
	}
	
	public void editEmployee()
	{
		
	}
	
	public void deleteEmployee()
	{
		
	}
	
	public void viewEmployee()
	{
		
	}
	
	public void searchEmployee()
	{
		
	}

	// Claim Type
	
	public void addClaimType()
	{
		
	}
	
	public void editClaimType()
	{
		
	}
	
	public void deleteClaimType()
	{
		
	}
	
	public void viewClaimType()
	{
		
	}
	
	public void searchClaimType()
	{
		
	}
	
	// Claim
	
	public void addClaim()
	{
		
	}
	
	public void editClaim()
	{
		
	}
	
	public void deleteClaim()
	{
		
	}
	
	public void viewClaim()
	{
		
	}
	
	public void searchClaim()
	{
		
	}
}