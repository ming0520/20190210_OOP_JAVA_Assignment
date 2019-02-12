package control;

import java.util.Scanner;

public class User 
{
	public static void displayUserMenu() 
	{
		System.out.println("*********************** User Menu ***********************");
		System.out.println("* 1. Apply Claim					*");
		System.out.println("* 2. Edit Claim     					*");
		System.out.println("* 3. Cancel Claim					*");
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
		}
		input.close();
	}
	
	// Claim (User)
	
	public static void applyUserClaim()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Employee's ID: ");
		String empID = input.nextLine();
		System.out.print("Claim Type ID: ");
		String claimTypeID = input.nextLine();
		System.out.print("Amount: ");
		float amount = input.nextFloat();
		System.out.print("Remark: ");
		String remark = input.nextLine();
		
		
		
		userClaimView();
		input.close();
	}
		
	public static void editUserClaim()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Employee's ID: ");
		String empID = input.nextLine();
		System.out.print("Claim Type ID: ");
		String claimTypeID = input.nextLine();
		
		
		System.out.print("New Amount: ");
		float amount = input.nextFloat();
		System.out.print("New Remark: ");
		String remark = input.nextLine();
		
		
		
		userClaimView();
		input.close();
	}
		
	public static void cancelUserClaim()
	{
		Scanner input = new Scanner(System.in);
		
		System.out.print("Employee's ID: ");
		String empID = input.nextLine();
		System.out.print("Claim ID: ");
		String claimID = input.nextLine();
		
		
		
		userClaimView();
		input.close();
	}
}
