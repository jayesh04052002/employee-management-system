import java.util.*;
class Employee
{
	private int Id;
	private String Name;
	private String JoiningDate;
	private String Department;
	private double Salary;
	
	Employee(int Id, String Name, String JoiningDate, String Department,double Salary)
	{
		this.Id = Id;
		this.Name=Name;
		this.JoiningDate=JoiningDate;
		this.Department = Department;
		this.Salary = Salary;
	}
	
	public void setId(int Id)
	{
		this.Id=Id;
	}
	public int getID()
	{
		return Id;
	}
	
	public void setName(String Name)
	{
		this.Name=Name;
	}
	public String getName()
	{
		return Name;
	}
	
	public void setJoiningDate(String JoiningDate)
	{
		this.JoiningDate=JoiningDate;
	}
	public String getJoiningDate()
	{
		return JoiningDate;
	}
	
	public void setDepartment(String Department)
	{
		this.Department=Department;
	}
	public String getDepartment()
	{
		return Department;
	}
	
	public void setSalary(double Salary)
	{
		this.Salary = Salary;
	}
	public double getSalary()
	{
		return Salary;
	}
	
	public String toString()
	{
		return "{Employee= ID:" + Id + ",Name:" +Name+ ",JoiningDate:" +JoiningDate+ ",Department:" +Department+ ",Salary:" +Salary+ "}";
	}
}

public class Main
{
	public static void main(String[] args)
	{
		
		Scanner sc = new Scanner(System.in);
		int choice;
		
		ArrayList<Employee> employees = new ArrayList<>();
		while(true)
		{
			System.out.println("Employee Management System");
			System.out.println("1. Add Employee");
			System.out.println("2. Display All Employees");
			System.out.println("3. Search Employee By ID");
			System.out.println("4. Remove Employee");
			System.out.println("5. Update Salary");
			System.out.println("6. Highest Paid Employee");
			System.out.println("7. Employees Sort By Salary");
			System.out.println("8. Employees Sort By Joining Date:");
			System.out.println("9. Group Employees By Department:");
			System.out.println("0. Exit");
			
			choice = sc.nextInt();
			
			switch(choice){
				case 1:
					System.out.println("Entere ID:");
					int Id = sc.nextInt();
					sc.nextLine();
					
					System.out.println("Enter Name:");
					String Name = sc.nextLine();
					
					System.out.println("Entere Joining Date:");
					String JoiningDate = sc.nextLine();
					
					System.out.println("Entere Department:");
					String Department = sc.nextLine();
					
					System.out.println("Entere Salary:");
					double Salary = sc.nextDouble();
					if(Salary<=0)
					{
						System.out.println("Invalid Salary");
					}
					
					Employee emp = new Employee(Id,Name,JoiningDate,Department,Salary);
					employees.add(emp);
					
					System.out.println("Employee Added");
					break;
					
				case 2:
						if(employees.isEmpty())
						{
							System.out.println("employees Not found");
						}
						else
						{
							for(Employee e : employees)
							{
								System.out.println(e.toString());
							}
						}
					break;
					
				case 3:
					System.out.println("Entere ID:");
					int Search_Id = sc.nextInt();
					boolean isFound = false;
					if(Search_Id > 0)
					{
						for(Employee e1 : employees)
						{
							if(Search_Id == e1.getID())
							{
								isFound=true;
								System.out.println(e1.toString());
								break;
							}
						}
						if(!isFound)
						{
							System.out.println("Employee Not Found");
						}
						
					}	
					else
					{
						System.out.println("Invalid ID");
					}						
					break;
				
				
				case 4:
					System.out.println("Enter ID:");
					int remove_Id = sc.nextInt();
					boolean flag = false;
					if(remove_Id>0)
					{
						for(Employee e2:employees)
						{
							if(remove_Id == e2.getID())
							{
								flag = true;
								employees.remove(e2);
								System.out.println("Employee Deleted SuccessFully");
								break;
							}
						}
						if(!flag)
						{
							System.out.println("Employee Not Found");
						}
					}
					else{
						System.out.println("Invalid ID");
					}
					break;
					
				case 5:
						System.out.println("Entere Id:");
						int searchIdToUpdateSalary = sc.nextInt();
						boolean isFind = false;
						for(Employee e: employees)
						{
							if(searchIdToUpdateSalary == e.getID())
							{
								isFind = true;
								System.out.println("Enter new Salary:");
								double updatedSalary = sc.nextDouble();
								e.setSalary(updatedSalary);
								System.out.println("Salary Updated");
								break;
							}	
						}
						if(!isFind)
						{
							System.out.println("Employee Not Found");
						}
						break;
						
				case 6:
						if(employees.isEmpty())
						{
							System.out.println("Employees Not Found");
						}
						else
						{
							double highestSalary = employees.get(0).getSalary();
							for(Employee e:employees)
							{
								if(highestSalary<e.getSalary())
								{
									highestSalary = e.getSalary();
								}
							}
							System.out.println(highestSalary);
						}
						break;
				case 7:
						for(int i = 0; i < employees.size() - 1; i++)
						{
							for(int j = i + 1; j < employees.size(); j++)
							{
								if(employees.get(i).getSalary() > employees.get(j).getSalary())
								{
									Employee temp = employees.get(i);

									employees.set(i, employees.get(j));
									employees.set(j, temp);
								}
							}
						}
						for(Employee e7:employees)
						{
							System.out.println(e7);
						}
						break;
						
				case 8:
						for(int i=0;i<employees.size()-1;i++)
						{
							for(int j=i+1;j<employees.size()-1;j++)
							{
								if(employees.get(i).getJoiningDate()
										.compareTo(employees.get(j).getJoiningDate()) > 0)
								{
									Employee temp = employees.get(i);

									employees.set(i, employees.get(j));
									employees.set(j, temp);
								}
							}
						}
						for(Employee e7:employees)
						{
							System.out.println(e7);
						}
						break;
				case 9:
						if(employees.isEmpty())
						{
							System.out.println("Employees Not Found");
						}
						else
						{
							Map<String, List<Employee>> map = new HashMap<>();
							for(Employee e9:employees)
							{
								String dept = e9.getDepartment();
								if(!map.containsKey(dept))
								{
									map.put(dept, new ArrayList<>());
								}
								map.get(dept).add(e9);
							}
							System.out.println(map);
						}
						break;
				case 0:
					System.out.println("Exiting");
					return;
			}
		}
		
	}
}
	
