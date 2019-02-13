package record;

import database.Dbh;

import java.text.SimpleDateFormat;

import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class ClaimRecord
{
	private String claimID;
	private String empID;
	private String claimTypeID;
	private String date;
	private float amount;
	private String remark;
	private String approverID;
	private ClaimStatus status = ClaimStatus.PENDING;
	private String decisionRemark;
	private int rowCount;
	
	public enum ClaimStatus
	{
		PENDING,
		APPROVED,
		REJECTED,
		CANCELLED;
	}
	
	public ClaimRecord()
	{
		this.claimID  = null;
		this.empID = null;
		this.claimTypeID = null;
		this.date = null;
		this.remark = null;
		this.approverID = null;
		this.status = ClaimStatus.PENDING;
		this.decisionRemark = null;
	}
	
	public ClaimRecord(String claimID, String empID, String claimTypeID, String date, float amount, String remark, String approverID, ClaimStatus status, String decisionRemark)
	{
		this.claimID = claimID;
		this.empID = empID;
		this.claimTypeID = claimTypeID;
		this.date = date;
		this.amount = amount;
		this.remark = remark;
		this.approverID = approverID;
		this.status = status;
		this.decisionRemark = decisionRemark;
	}
	
	public void SetClaimID(String claimID) 
	{
		this.claimID = claimID;
	}
	
	public String GetClaimID()
	{
		return claimID;
	}
	
	public void SetEmpID(String empID) 
	{
		this.empID = empID;
	}
	
	public String GetEmpID()
	{
		return empID;
	}
	
	public void SetClaimTypeID(String claimTypeID) 
	{
		this.claimTypeID = claimTypeID;
	}
	
	public String GetClaimTypeID()
	{
		return claimTypeID;
	}
	
	public void SetDate(String date) 
	{
		this.date = date;
	}
	
	public String GetDate()
	{
		return date;
	}
	
	public void SetAmount(float amount)
	{
		this.amount = amount;
	}
	
	public float GetAmount() 
	{
		return amount;
	}
	
	public void SetRemark(String remark) 
	{
		this.remark = remark;
	}
	
	public String GetRemark() 
	{
		return remark;
	}
	
	public void SetApproverID(String approverID) 
	{
		this.approverID = approverID;
	}
	
	public String GetApproverID() 
	{
		return approverID;
	}
	
	public void SetStatus(ClaimStatus status) 
	{
		this.status = status;
	}
	
	public ClaimStatus GetStatus() 
	{
		return status;
	}
	
	public void SetDecisionRemark(String decisionRemark)
	{
		this.decisionRemark = decisionRemark;
	}
	
	public String GetDecisionRemark() 
	{
		return decisionRemark;
	}
	
	public void DisplayClaim() {
		Dbh db = new Dbh();
		String sql = "SELECT * FROM claimrecord";
		
		try {
//			int counter = 0;
			db.connect();
//			ResultSet rsRowCount = db.getStatement().executeQuery(""
//					+ "SELECT COUNT(*) FROM claimrecord");
//			
//			int rowCount = rsRowCount.getInt(1);
//			
//			ClaimRecord[] claimRecord = new ClaimRecord[rowCount];
//			this.rowCount = rowCount;
//			
//			rsRowCount.close();
			
			ResultSet rs = db.getStatement().executeQuery(sql);
			
			System.out.println("=============================================== Claim Record ==========================================================================");
			System.out.println("Claim ID \t\t Employee ID \t\t Claim Type ID \t\t Date \t\t Amount \t\t Remark \t\t Approver ID \t\t Claim Status \t\t Decision Remark");
			
			while(rs.next()) {
				String claimId = rs.getString("claimID");
				String empId = rs.getString("empID");
				String claimTypeId = rs.getString("claimTypeID");
				String date = rs.getString("date");
				float amount = rs.getFloat("amount");
				String remark = rs.getString("remark");
				String approverId = rs.getString("approverID");
				String claimStatus = rs.getString("claimStatus");
				String decisionRemark = rs.getString("decisionRemark");
				String tab = " \t\t ";
				
				System.out.print(claimId + tab);
				System.out.print(empId + tab);
				System.out.print(claimTypeId + tab);
				System.out.print(date + tab);
				System.out.print(amount + tab);
				System.out.print(remark + tab);
				System.out.print(approverId + tab);
				System.out.print(claimStatus + tab);
				System.out.print(decisionRemark);
				System.out.println("");
			}

			rs.close();
			db.closeConnection();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean ApplyClaim () {
		
		if(this.claimID == null || this.empID == null || this.date == null || this.approverID == null) {
			return false;
		}
		
		Dbh db = new Dbh();
		String insertCRSql = "INSERT INTO claimrecord (claimID,empID,claimTypeID,date,amount,remark,approverID,claimStatus,decisionRemark)"
									+" VALUES (?,		?,		?,			?,	?,		?,		?,			?,			?)";
		try {
			db.connect();
			PreparedStatement addRecord = db.getConnection().prepareStatement(insertCRSql);
			
			addRecord.setString(1, this.claimID);
			addRecord.setString(2, this.empID);
			addRecord.setString(3, this.claimTypeID);
			addRecord.setString(4, this.date);
			addRecord.setFloat(5, this.amount);
			addRecord.setString(6, this.remark);
			addRecord.setString(7, this.approverID);
			addRecord.setString(8, this.status.toString());
			addRecord.setString(10, this.decisionRemark);
			
			addRecord.executeQuery();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean ApplyClaim (ClaimRecord newClaim) {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		if(newClaim.claimID == null || newClaim.empID == null || newClaim.date == null) {
			return false;
		}
		
		Dbh db = new Dbh();
		String insertCRSql = "INSERT INTO claimrecord (claimID,empID,claimTypeID,date,amount,remark,claimStatus)"
											+" VALUES (?		,?	,	?		, ?	 ,	?	,	?	,	?)";
		try {
			db.connect();
			PreparedStatement addRecord = db.getConnection().prepareStatement(insertCRSql);
			
			addRecord.setString(1, newClaim.claimID);
			addRecord.setString(2, newClaim.empID);
			addRecord.setString(3, newClaim.claimTypeID);
			addRecord.setString(4, newClaim.date);
			addRecord.setFloat(5, newClaim.amount);
			addRecord.setString(6, newClaim.remark);
			addRecord.setString(7, newClaim.status.toString());
			
			addRecord.executeQuery();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	
}
