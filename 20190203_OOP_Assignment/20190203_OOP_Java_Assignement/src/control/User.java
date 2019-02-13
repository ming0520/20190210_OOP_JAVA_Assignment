package control;

import java.util.Scanner;
import record.ClaimRecord;
import record.ClaimRecord.ClaimStatus;

public class User 

{
	
	public static void main(String[] args) {
		User.userClaimView();
	}
	
	public static void displayUserMenu() 
	{
		System.out.println("*********************** User Menu ***********************");
		System.out.println("* 1. Apply Claim					*");
		System.out.println("* 2. Edit Claim     					*");
		System.out.println("* 3. Cancel Claim					*");
//		System.out.println("* 4. Back To Main Menu                            	*");
		System.out.println("* Enter the number and press <enter> to continue	*");
		System.out.println("*********************************************************");	
	}
	
	
	public static void userClaimView()
	{
		Scanner input = new Scanner(System.in);
		displayUserMenu();
		
		int choice = 0;
		System.out.println("Enter Choice: ");
		//Check to choice
		while(true) {
		    //Try to get an integer
		    try {
		         choice = Integer.parseInt(input.nextLine());
		         // The range for the choice
		         if (choice > 0 && choice <= 3)
		              break;
		         else
		        	 System.out.print("Invalid choice! Please try again:");
		         // not positive. 
		    } catch (NumberFormatException e) {
		         // not an integer
		    	System.out.print("Invalid choice! Please try again:");
		    }
		}
		
		switch(choice)
		{
			case 1: applyUserClaim();break;
			case 2: editUserClaim();break;
			case 3: cancelUserClaim();break;
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
		
		ClaimRecord newClaim = new ClaimRecord();
		
		newClaim.SetEmpID(empID);
		newClaim.SetClaimTypeID(claimTypeID);
		newClaim.SetAmount(amount);
		newClaim.SetRemark(remark);
		newClaim.SetStatus(ClaimStatus.PENDING);
		
		if(newClaim.ApplyClaim() == true) {
			System.out.println("Applied for claim!");
		}else {
			System.out.println("Cannot apply for the claim. Please try again!");
		}
		
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
