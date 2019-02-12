package record;

public class Employee 
{
	private String empID;
	private String password;
	private String name;
	private String department;
	private String position;
	private UserRole userRole;
	private Status status;
	private String superiorID;
	
	public enum UserRole
	{
		ADMIN,
		USER;
	}
	public enum Status
	{
		ACTIVE,
		INACTIVE;
	}
	
	public Employee()
	{
		
	}
	
	public Employee(String name, String password)
	{
		this.name = name;
		this.password = password;
	}
	
	public Employee(String empID)
	{
		this.empID = empID;
	}
	
	public Employee(String empID, String password, String name,String department, String position, UserRole userRole, Status status, String superiorID)
	{
		this.empID = empID;
		this.password = password;
		this.name = name;
		this.department = department;
		this.position = position;
		this.userRole = userRole;
		this.status = status;
		this.superiorID = superiorID;
	}
	
	public void SetEmpID(String empID) 
	{
		this.empID = empID;
	}
	
	public String GetEmpID()
	{
		return empID;
	}
	
	public void SetPassword(String password) 
	{
		this.password = password;
	}
	
	public String GetPassword()
	{
		return password;
	}
	
	public void SetName(String name) 
	{
		this.name = name;
	}
	
	public String GetName()
	{
		return name;
	}
	
	public void SetDepartment(String department) 
	{
		this.department = department;
	}
	
	public String GetDepatment()
	{
		return department;
	}
	
	public void SetPosition(String position) 
	{
		this.position = position;
	}
	
	public String GetPosition()
	{
		return position;
	}
	
	public void SetStatus(Status status) 
	{
		this.status = status;
	}
	
	public Status GetStatus()
	{
		return status;
	}
	
	public void SetUserRole(UserRole userRole)
	{
		this.userRole = userRole;
	}
	
	public UserRole GetUserRole()
	{
		return userRole;
	}
	
	public void SetSuperiorID(String superiorID) 
	{
		this.superiorID = superiorID;
	}
	
	public String GetSuperiorID()
	{
		return superiorID;
	}
	
	public void displayEmployee() {
		System.out.println("=================================================================");
		System.out.println("                       Employee Profile");
		System.out.println("-----------------------------------------------------------------");
		System.out.println("ID		:\t" + this.GetEmpID());
		System.out.println("Name		:\t" + this.GetName());
		System.out.println("Department	:\t" + this.GetDepatment());
		System.out.println("Position	:\t" + this.GetPosition());
		System.out.println("Status		:\t" + this.GetStatus().toString());
		System.out.println("Role		:\t"+this.GetUserRole().toString());
		System.out.println("Superior ID 	:\t"+ this.GetSuperiorID());
		System.out.println("=================================================================");
	}
}
