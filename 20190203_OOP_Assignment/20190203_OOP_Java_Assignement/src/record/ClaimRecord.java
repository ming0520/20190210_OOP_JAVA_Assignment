package record;

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
	
	public enum ClaimStatus
	{
		PENDING,
		APPROVED,
		REJECTED,
		CANCELLED;
	}
	
	public ClaimRecord()
	{
		
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
	
	public boolean ApplyClaim()
	{
		if(claimID == null || empID == null || claimTypeID == null || date == null || approverID == null) 
		{
			return false;
		}
		return true;
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
}
