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
	
	public DefaultData() {
		empInfo = new Employee();
		empInfo.SetDepartment("Human Resource");
		empInfo.SetEmpID("IMS-H-001");
		empInfo.SetName("Alexandar");
		empInfo.SetPassword("123");
		empInfo.SetPosition("Manager");
		empInfo.SetStatus(Status.ACTIVE);
		empInfo.SetSuperiorID("IMS-D");
		empInfo.SetUserRole(UserRole.ADMIN);
		empList[0] = empInfo;
		
		empInfo = null;
		
		empInfo.SetDepartment("IT Department");
		empInfo.SetEmpID("IMS-T-001");
		empInfo.SetName("Julice");
		empInfo.SetPassword("123");
		empInfo.SetPosition("Manager");
		empInfo.SetStatus(Status.INACTIVE);
		empInfo.SetSuperiorID("IMS-D");
		empInfo.SetUserRole(UserRole.ADMIN);
		empList[1] = empInfo;
	}

}
