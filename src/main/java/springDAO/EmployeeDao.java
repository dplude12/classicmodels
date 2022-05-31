package springDAO;

import java.util.List;

import springModel.Employee;

public interface EmployeeDao {

	public List<Employee> empList();
	
    public void saveOrUpdate(Employee emp);
    
    public void delete(int employeeId);
     
    public Employee get(int employeeId);

	List<Employee> empListByOffice(String officCode);

} 