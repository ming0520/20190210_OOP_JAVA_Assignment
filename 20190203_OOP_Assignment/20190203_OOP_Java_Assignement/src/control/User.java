package control;

import java.util.Scanner;

import record.ClaimRecord;
import record.ClaimRecord.ClaimStatus;

import record.Employee;

import database.Dbh;
import control.Main;

public class User 

{
	
	private static Main main = new Main();
	private static Employee empInfo = main.getEmployee();

	public static void main(String[] args) {
		User.userClaimView();
	}
	
	public static void displayUserMenu() 
	{
		System.out.println("=================================================================");
		System.out.println("                       User Menu ");
		System.out.println("-----------------------------------------------------------------");
		System.out.println(" 1. Apply Claim					");
		System.out.println(" 2. Edit Claim     					");
		System.out.println(" 3. Cancel Claim					");
		System.out.println(" 4. View Claim					");
//		System.out.println("* 4. Back To Main Menu                            	");
		System.out.println(" Enter the number and press <enter> to continue	");
		System.out.println("=================================================================");	
	}
	
	public static void viewClaim() {
		ClaimRecord claimRecord = new ClaimRecord();
		
		claimRecord.DisplayClaim("SELECT * FROM claimrecord WHERE empID = '" + User.empInfo.GetEmpID() + "'");
	}
	
	
	public static void userClaimView()
	{
		
		displayUserMenu();
		Scanner input = new Scanner(System.in);
		int choice = 0;
		System.out.print("Enter Choice: ");
		//Check to choice
		while(true) 
		{
		    //Try to get an integer
		    try
		    {
		         choice = Integer.parseInt(input.nextLine());
		         // The range for the choice
		         if (choice > 0 && choice <= 4)
		         {
		              break;
		         }
		         else
		         {
		        	 System.out.print("Invalid choice! Please try again:");
		         // not positive. 
		         }
		    } 
		    catch (NumberFormatException e) 
		    {
		         // not an integer
		    	System.out.print("Invalid choice! Please try again:");
		    	return;
		    }
		}
		
		switch(choice)
		{
			case 1: applyUserClaim();break;
			case 2: editUserClaim();break;
			case 3: cancelUserClaim();break;
			case 4: viewClaim();break;
		}
		
		userClaimView();
		
	}
	
	// Claim (User)
	
	public static boolean applyUserClaim()
	{
		Scanner input = new Scanner(System.in);
		
		Main main = new Main();
		Employee empInfo = main.getEmployee();
			System.out.println("=================================================================");	
			System.out.println("                    Application for Claim");
			System.out.println("-----------------------------------------------------------------");
			String empID = empInfo.GetEmpID();
			System.out.println("Employe ID: " + empID);
			System.out.print("Claim Type ID: ");
			String claimTypeID = input.nextLine();
			
			System.out.print("Amount: ");
			float amount = input.nextFloat();
			
			System.out.print("Remark: ");
			input.nextLine();
			String remark = input.nextLine();
			
			ClaimRecord newClaim = new ClaimRecord();
			
			newClaim.SetEmpID(empID);
			newClaim.SetClaimTypeID(claimTypeID);
			newClaim.SetAmount(amount);
			newClaim.SetRemark(remark);
			newClaim.SetStatus(ClaimStatus.PENDING);
			if(newClaim.ApplyClaim() == true) {
				System.out.println("Successful apply for the claim!");
			}else
				System.out.println("Unsuccessful apply for the claim!\nPlease try again");
			
			System.out.println("=================================================================");
			return true;
	}
		
	public static void editUserClaim()
	{
		Scanner input = new Scanner(System.in);
		
		Main main = new Main();
		Employee empInfo = main.getEmployee();
		ClaimRecord claimRecord = new ClaimRecord();
		
		String empID = empInfo.GetEmpID();
		claimRecord.SetEmpID(empID);
		claimRecord.DisplayClaim("SELECT * FROM claimrecord WHERE empID = '" +empID + "'");
		
		System.out.println("Employe ID: " + empID);
		
		do {
			System.out.print("Claim ID: ");
			String claimID = input.nextLine();
			claimRecord.SetClaimID(claimID);
		}while(claimRecord.verifyClaimID() == false);
		
		float amount = (float) 0.0;
		do {
			System.out.print("New Amount: ");
			amount = input.nextFloat(); 
		}while(amount < 0.0);
		
		String remark = null;
		do {
			System.out.print("New Remark: ");
			input.nextLine();
			remark = input.nextLine();
			if(remark == null) {
				System.out.print("Please try again,");
			}
		}while(remark == null);
		
		claimRecord.SetAmount(amount);
		claimRecord.SetRemark(remark);
		claimRecord.editClaim();
		userClaimView();
		input.close();
	}
		
	public static void cancelUserClaim()
	{
		Main main = new Main();
		Employee empInfo = main.getEmployee();
		Scanner input = new Scanner(System.in);
		ClaimRecord claimRecord = new ClaimRecord();
		claimRecord.DisplayClaim("SELECT * FROM claimrecord WHERE empID ='" + empInfo.GetEmpID() + "'");
		do {
			System.out.print("Claim ID: ");
			String claimID = input.nextLine();
			claimRecord.SetClaimID(claimID);
		}while (claimRecord.verifyClaimID() == false);
		
		claimRecord.SetStatus(ClaimStatus.CANCELLED);
		
		System.out.print("New decision remark: ");
		String decisionRemark = input.nextLine();
		claimRecord.SetDecisionRemark(decisionRemark);
		
		claimRecord.approveClaim();

		userClaimView();
		input.close();
	}
}
