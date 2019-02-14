package record;

import database.Dbh;
import java.sql.*;

public class ClaimType
{
	private String claimTypeID;
	private String claimTypeName;
	private String applicableToPosition;
	private float limit;
	
	public ClaimType()
	{
		
	}
	
	public ClaimType(String claimTypeName, String applicableToPosition)
	{
		this.claimTypeName = claimTypeName;
		this.applicableToPosition = applicableToPosition;
	}
	
	public ClaimType(String claimTypeID, String claimTypeName, String applicableToPosition, float limit)
	{
		this.claimTypeID = claimTypeID;
		this.claimTypeName = claimTypeName;
		this.applicableToPosition = applicableToPosition;
		this.limit = limit;
	}
	
	public ClaimType(String empID, String claimTypeID, String claimTypeName, String applicableToPosition)
	{
		this.claimTypeID = claimTypeID;
		this.claimTypeName = claimTypeName;
		this.applicableToPosition = applicableToPosition;
	}
	
	public void SetClaimTypeID(String claimTypeID)
	{
		this.claimTypeID = claimTypeID;
	}
	
	public String GetClaimTypeID()
	{
		return claimTypeID;
	}
	
	public void SetClaimTypeName(String claimTypeName)
	{
		this.claimTypeName = claimTypeName;
	}
	
	public String GetClaimTypeName()
	{
		return claimTypeName;
	}
	
	public void SetApplicableToPosition(String applicableToPosition)
	{
		this.applicableToPosition = applicableToPosition;
	}
	
	public String GetApplicableToPosition()
	{
		return applicableToPosition;
	}
	
	public void SetLimit(float limit)
	{
		this.limit = limit;
	}
	
	public float GetLimit()
	{
		return limit;
	}
	
	public void printClaimType() {
		System.out.println("=================================================================");
		System.out.println("                      Claim Type Record");
		System.out.println("-----------------------------------------------------------------");
		System.out.println("Claim Type ID          : " + this.claimTypeID);
		System.out.println("Claim Name             : " + this.claimTypeName);
		System.out.println("Applicable to Position : " + this.applicableToPosition);
		System.out.println("Limit                  : " + this.limit);
		System.out.println("=================================================================");
	}
	
	public void displayClaimType() {
		String sql = "SELECT * FROM claimtype WHERE ?";
		Dbh db = new Dbh();
		
		try {
			db.connect();
			PreparedStatement stmt = db.getConnection().prepareStatement(sql);
			stmt.setString(1, "1");
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				this.claimTypeID = rs.getString("claimTypeID");
				this.claimTypeName = rs.getString("claimTypeName");
				this.applicableToPosition = rs.getString("applicableToPosition");
				this.limit = rs.getFloat("claimLimit");
				this.printClaimType();
			}
			
		}catch(Exception se) {
			se.printStackTrace();
		}
	}
}