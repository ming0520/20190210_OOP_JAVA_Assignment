package record;

import record.ClaimRecord.ClaimStatus;
import record.Employee.Status;
import record.Employee.UserRole;

public class DefaultData {
	public static final int ARRAY_SIZE = 1000;
	public static Employee[] empList = new Employee[ARRAY_SIZE];
	public static ClaimType[] claimTypeList = new ClaimType [ARRAY_SIZE];
	public static ClaimRecord[] claimRecord = new ClaimRecord[10000];
	private Employee empInfo;
	private ClaimType claimInfo;
	private ClaimRecord recordInfo;
	
	public DefaultData()
	{
//		Construct Employee Record
		empInfo = new Employee();
		
		empInfo.SetDepartment("Director");
		empInfo.SetEmpID("IMS-D");
		empInfo.SetName("Terence");
		empInfo.SetPassword("123");
		empInfo.SetPosition("Chief of Director");
		empInfo.SetStatus(Status.ACTIVE);
		empInfo.SetSuperiorID("B");
		empInfo.SetUserRole(UserRole.ADMIN);
		empList[0] = empInfo;
		
		empInfo = null;
		
		empInfo.SetDepartment("Human Resource");
		empInfo.SetEmpID("IMS-H-001");
		empInfo.SetName("Alexandar");
		empInfo.SetPassword("123");
		empInfo.SetPosition("Manager");
		empInfo.SetStatus(Status.ACTIVE);
		empInfo.SetSuperiorID("C");
		empInfo.SetUserRole(UserRole.ADMIN);
		empList[1] = empInfo;
		
		empInfo = null;
		
		empInfo.SetDepartment("IT Department");
		empInfo.SetEmpID("IMS-T-001");
		empInfo.SetName("Julice");
		empInfo.SetPassword("123");
		empInfo.SetPosition("Manager");
		empInfo.SetStatus(Status.INACTIVE);
		empInfo.SetSuperiorID("C");
		empInfo.SetUserRole(UserRole.ADMIN);
		empList[2] = empInfo;
		
		empInfo = null;
		
		empInfo.SetDepartment("Marketing");
		empInfo.SetEmpID("IMS-S-001");
		empInfo.SetName("Mami");
		empInfo.SetPassword("123");
		empInfo.SetPosition("Sales");
		empInfo.SetStatus(Status.ACTIVE);
		empInfo.SetSuperiorID("D");
		empInfo.SetUserRole(UserRole.USER);
		empList[3] = empInfo;
		
		empInfo = null;
		
		empInfo.SetDepartment("Marketing");
		empInfo.SetEmpID("IMS-S-002");
		empInfo.SetName("Bryan");
		empInfo.SetPassword("123");
		empInfo.SetPosition("Sales");
		empInfo.SetStatus(Status.ACTIVE);
		empInfo.SetSuperiorID("D");
		empInfo.SetUserRole(UserRole.USER);
		empList[3] = empInfo;
		
		empInfo = null;
		
		empInfo.SetDepartment("Executive Officer");
		empInfo.SetEmpID("CEO-001");
		empInfo.SetName("Sam");
		empInfo.SetPassword("123");
		empInfo.SetPosition("CEO");
		empInfo.SetStatus(Status.ACTIVE);
		empInfo.SetSuperiorID("A");
		empInfo.SetUserRole(UserRole.ADMIN);
		empList[4] = empInfo;
		
//		Construct Claim Type Record
		
		claimInfo = new ClaimType();
		
		claimInfo.SetApplicableToPosition("CEO");
		claimInfo.SetClaimTypeID("001");
		claimInfo.SetClaimTypeName("ACCIDENTAL DEATH");
		claimInfo.SetLimit(1000000);
		claimTypeList[1] = claimInfo;
				
		claimInfo = null;
		
		claimInfo.SetApplicableToPosition("Manager");
		claimInfo.SetClaimTypeID("002");
		claimInfo.SetClaimTypeName("DEATH OR TPD BENEFIT");
		claimInfo.SetLimit(50000);
		claimTypeList[2] = claimInfo;
		
		claimInfo = null;
		
		claimInfo.SetApplicableToPosition("Sales");
		claimInfo.SetClaimTypeID("003");
		claimInfo.SetClaimTypeName("Psychological conditions");
		claimInfo.SetLimit(40000);
		claimTypeList[3] = claimInfo;
		
		claimInfo = null;
		
		claimInfo.SetApplicableToPosition("Chief of Director");
		claimInfo.SetClaimTypeID("004");
		claimInfo.SetClaimTypeName("Vision loss");
		claimInfo.SetLimit(50000);
		claimTypeList[4] = claimInfo;
		
		claimInfo = null;
		
		claimInfo.SetApplicableToPosition("Sales");
		claimInfo.SetClaimTypeID("005");
		claimInfo.SetClaimTypeName("Hearing loss");
		claimInfo.SetLimit(50000);
		claimTypeList[5] = claimInfo;

//		Construct Claim Record
		
		recordInfo = new ClaimRecord();
		
		recordInfo.SetEmpID("IMS-S-001");
		recordInfo.SetClaimTypeID("001");
		recordInfo.SetClaimID("12345");
		recordInfo.SetDate("2018-02-29");
		recordInfo.SetAmount(60000);
		recordInfo.SetRemark("Testing 123");
		recordInfo.SetApproverID("12345");
		recordInfo.SetStatus(ClaimStatus.PENDING);
		recordInfo.SetDecisionRemark("No job");
		claimRecord[0] = recordInfo;
		
		recordInfo = null;
		
		recordInfo.SetEmpID("IMS-S-002");
		recordInfo.SetClaimTypeID("002");
		recordInfo.SetClaimID("67890");
		recordInfo.SetDate("2018-03-20");
		recordInfo.SetAmount(70000);
		recordInfo.SetRemark("Testing 456");
		recordInfo.SetApproverID("67890");
		recordInfo.SetStatus(ClaimStatus.PENDING);
		recordInfo.SetDecisionRemark("Injury");
		claimRecord[1] = recordInfo;
		
		recordInfo = null;
		
		recordInfo.SetEmpID("IMS-T-001");
		recordInfo.SetClaimTypeID("003");
		recordInfo.SetClaimID("54321");
		recordInfo.SetDate("2018-06-19");
		recordInfo.SetAmount(50000);
		recordInfo.SetRemark("Testing 789");
		recordInfo.SetApproverID("54321");
		recordInfo.SetStatus(ClaimStatus.PENDING);
		recordInfo.SetDecisionRemark("Lack of vitamin");
		claimRecord[2] = recordInfo;
	}
}