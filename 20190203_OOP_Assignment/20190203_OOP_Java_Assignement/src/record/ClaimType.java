package record;

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
}