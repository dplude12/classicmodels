package springDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import springModel.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private JdbcTemplate jdbcTemplate;

	public EmployeeDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Employee emp) {
        // implementation details goes here...
	    if (emp.getEmployeeId() > 0) {
	        // update
	    	String sql = "UPDATE employees SET employeeNumber=?, lastName=?, firstName=?, extension=?, "
	                    + "email=?, officeCode=?, reportsTo=?, jobTitle=? WHERE employeeID=?";
	        jdbcTemplate.update(sql, emp.getEmployeeNumber(), emp.getLastName(), emp.getFirstName(), emp.getExtension(),
	        		emp.getEmail(), emp.getOfficeCode(), emp.getReportsTo(), emp.getJobTitle(),emp.getEmployeeId());
	        
	    } else {
	        // insert
	    	
	    	String sql = "INSERT INTO employees (employeeNumber, lastName, firstName, extension, email, officeCode, reportsTo, jobTitle)"
	                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	        jdbcTemplate.update(sql, emp.getEmployeeNumber(), emp.getLastName(), emp.getFirstName(), emp.getExtension(),
	        		emp.getEmail(), emp.getOfficeCode(), emp.getReportsTo(), emp.getJobTitle());
	                
	    }
	 
    }
 
	@Override
    public void delete(int employeeID) {
        // implementation details goes here...
		String sql = "DELETE FROM employees WHERE employeeID=?";
		jdbcTemplate.update(sql, employeeID);
    }
    
    
	@Override
	public Employee get(int employeeID) {
		// TODO Auto-generated method stub
		   String sql = "SELECT * FROM employees WHERE employeeID =" + employeeID;
		    return jdbcTemplate.query(sql, new ResultSetExtractor<Employee>() {
		 
		        @Override
		        public Employee extractData(ResultSet rs) throws SQLException,
		                DataAccessException {
		            if (rs.next()) {
		                Employee emp = new Employee();
						emp.setEmployeeId(rs.getInt("employeeID"));
		                emp.setEmployeeNumber(rs.getInt("employeeNumber"));
						emp.setLastName(rs.getString("lastName"));
						emp.setFirstName(rs.getString("firstName"));
						emp.setExtension(rs.getString("extension"));
						emp.setEmail(rs.getString("email"));
						emp.setOfficeCode(rs.getString("officeCode"));
						emp.setReportsTo(rs.getInt("reportsTo"));
						emp.setJobTitle(rs.getString("jobTitle"));
		                return emp;
		            }
		 
		            return null;
		        }
		 
		    });
		}

	@Override
	public List<Employee> empList() {
		// TODO Auto-generated method stub

	    String sql = "SELECT * FROM employees";
	    List<Employee> listExmployee = jdbcTemplate.query(sql, new RowMapper<Employee>() {
	    	 
	        
	        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Employee emp = new Employee();

	            emp.setEmployeeId(rs.getInt("employeeID"));
				emp.setEmployeeNumber(rs.getInt("employeeNumber"));
				emp.setLastName(rs.getString("lastName"));
				emp.setFirstName(rs.getString("firstName"));
				emp.setExtension(rs.getString("extension"));
				emp.setEmail(rs.getString("email"));
				emp.setOfficeCode(rs.getString("officeCode"));
				emp.setReportsTo(rs.getInt("reportsTo"));
				emp.setJobTitle(rs.getString("jobTitle"));
	            
	            return emp;
	        }
	    });
	 
	    return listExmployee;
	}	

	
	@Override
	public List<Employee> empListByOffice(String officCode) {
		// TODO Auto-generated method stub

	    String sql = "SELECT * FROM employees where officeCode= '" + officCode +"'";
	    List<Employee> listExmployee = jdbcTemplate.query(sql, new RowMapper<Employee>() {

	        
	        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
	            Employee emp = new Employee();

	            emp.setEmployeeId(rs.getInt("employeeID"));
				emp.setEmployeeNumber(rs.getInt("employeeNumber"));
				emp.setLastName(rs.getString("lastName"));
				emp.setFirstName(rs.getString("firstName"));
				emp.setExtension(rs.getString("extension"));
				emp.setEmail(rs.getString("email"));
				emp.setOfficeCode(rs.getString("officeCode"));
				emp.setReportsTo(rs.getInt("reportsTo"));
				emp.setJobTitle(rs.getString("jobTitle"));
	            
	            return emp;
	        }
	    });
	 
	    return listExmployee;
	}
	
	
/*	
	public List<Employee> list() {
	    String sql = "SELECT * FROM Employees";
	     
	    return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Employee.class));  
	}
*/
	
}