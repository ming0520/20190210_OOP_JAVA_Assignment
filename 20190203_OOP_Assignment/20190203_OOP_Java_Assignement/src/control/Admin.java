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
	
	public void displayAdminMenu () {
		clearConsole();
		System.out.println("******************** Admin Menu *********************");
		System.out.println("* 1. Employee Record								*");
		System.out.println("* 2. Claim Type Record								*");
		System.out.println("* 2. Claim Record									*");
		System.out.println("* 3. Back To Main Menu                            	*");
		System.out.println("* Enter the number and press <enter> to continue	*");
		System.out.println("*****************************************************");	
	}
	
	
	public void displayEmployeeMenu(){	
		clearConsole();
		System.out.println("******************* Employee Menu *******************");
		System.out.println("* 1. Add Employee									*");
		System.out.println("* 2. Edit Employee									*");
		System.out.println("* 3. Delete Employee								*");
		System.out.println("* 3. View Employee									*");
		System.out.println("* 3. Search Employee								*");
		System.out.println("* 4. Back to Admin Menu								*");
		System.out.println("* Enter the number and press <enter> to continue	*");
		System.out.println("*****************************************************");		
	}
	
	public void displayClaimMenu(){
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
	
	public void displayClaimTypeMenu(){
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
	
	public void addEmployee() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter employee id :");
		String empID = input.nextLine();
	}
	
}
