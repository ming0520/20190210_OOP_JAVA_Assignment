package control;

import java.util.Scanner;

public class User 
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
}
