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
	
	public DefaultData() {
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
		
		claimInfo = null;
		
		claimInfo.SetApplicableToPosition("CEO");
		claimInfo.SetClaimTypeID("002");
		claimInfo.SetClaimTypeName("DEATH OR TPD BENEFIT");
		claimInfo.SetLimit(50000);
		
		claimInfo = null;
		
		claimInfo.SetApplicableToPosition("Manager");
		claimInfo.SetClaimTypeID("003");
		claimInfo.SetClaimTypeName("");
		claimInfo.SetLimit(50000);
		
		claimInfo = null;
		
		claimInfo.SetApplicableToPosition("Manager");
		claimInfo.SetClaimTypeID("004");
		claimInfo.SetClaimTypeName("Vision loss");
		claimInfo.SetLimit(50000);
	}

}
