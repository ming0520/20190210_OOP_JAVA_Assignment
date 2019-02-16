package record;

import database.Dbh;
import java.sql.*;

public class ClaimType extends Dbh
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
	
	public void displayClaimType(String sql) {
		Dbh db = new Dbh();
		
		try {
			db.connect();
			
			ResultSet rs = db.getStatement().executeQuery(sql);
			
			while(rs.next()) {
				this.claimTypeID = rs.getString("claimTypeID");
				this.claimTypeName = rs.getString("claimTypeName");
				this.applicableToPosition = rs.getString("applicableToPosition");
				this.limit = rs.getFloat("claimLimit");
				this.printClaimType();
			}
			db.closeConnection();
			rs.close();
			
		}catch(Exception se) {
			se.printStackTrace();
		}
		
		
	}
	
	public boolean addClaimType(){
		boolean flag = false;
		
		String selectSql = "SELECT * FROM claimtype WHERE claimTypeID = ?";
		String insertSql = "INSERT INTO claimtype (claimTypeID, claimTypeName,applicableToPosition,claimLimit)"
				+ "VALUES (?,?,?,?)";
		
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			this.connect();
			stmt = this.getConnection().prepareStatement(selectSql);
			stmt.setString(1, this.GetClaimTypeID());
			rs = stmt.executeQuery();
			rs.last();
			
			if(!(rs.getRow() > 0)) {
				System.out.println("Adding claim type...");
				stmt = this.getConnection().prepareStatement(insertSql);
				stmt.setString(1, this.GetClaimTypeID());
				stmt.setString(2, this.GetClaimTypeName());
				stmt.setString(3, this.GetApplicableToPosition());
				stmt.setFloat(4, this.GetLimit());
				stmt.executeUpdate();
				System.out.println("Claim type added successfully!");
				flag = true;
			}else {
				System.out.println("The claim type id existed, please try again!");
				flag = false;
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
			rs.close();
			stmt.close();
			this.closeConnection();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public boolean editClaimType() {
		boolean flag = false;
		String editSql = "UPDATE claimtype SET applicableToPosition=?, claimLimit=? WHERE claimTypeID=?";
		
		PreparedStatement stmt;
		
		try{
			
			this.connect();
			System.out.println("Updating...");
			stmt = this.getConnection().prepareStatement(editSql);
			stmt.setString(1, this.GetApplicableToPosition());
			stmt.setFloat(2, this.GetLimit());
			stmt.setString(3,this.GetClaimTypeID());
			stmt.executeUpdate();
			this.closeConnection();
			stmt.close();
			System.out.println("Updated successfully!");
			stmt.close();
			this.closeConnection();
			flag = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
				
		return flag;
	}
	
	public boolean deleteClaimType() {
		boolean flag = false;
			String deleteSql = "DELETE FROM claimtype WHERE claimTypeID=?";
			
			PreparedStatement stmt;
			
			try {
				System.out.println("Deleting...");
				this.connect();
				stmt = this.getConnection().prepareStatement(deleteSql);
				stmt.setString(1, this.GetClaimTypeID());
				stmt.executeUpdate();
				stmt.executeUpdate("ALTER TABLE claimtype DROP id");
				stmt.executeUpdate("ALTER TABLE claimtype ADD id int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT");
				System.out.println("Deleted successfully!");
				this.closeConnection();
				stmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		return flag;
	}
}