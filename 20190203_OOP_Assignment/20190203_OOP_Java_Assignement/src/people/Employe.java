package people;

public class Employe 
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
	
	
	public Employe()
	{
		
	}
	
	public Employe(String name, String password)
	{
		this.name = name;
		this.password = password;
	}
	
	public Employe(String empID)
	{
		this.empID = empID;
	}
	
	public Employe(String empID, String password, String name,String department, String position, UserRole userRole, Status status, String superiorID)
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
}
