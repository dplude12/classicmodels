package springDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import springModel.Customer;


public class CustomerDaoImpl implements CustomerDao {

	private JdbcTemplate jdbcTemplate;

	public CustomerDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Customer cust) {
        // implementation details goes here...
	    if (cust.getCustomerID() > 0) {
	        // update
	    	String sql = "UPDATE customers SET customerNumber=?,customerName=?,contactLastName=?,contactFirstName=?,phone=?,addressLine1=?,"
	                    + "addressLine2=?,city=?,state=?,postalCode=?,country=?,salesRepEmployeeNumber=?,creditLimit=? WHERE customerID=?";
	        jdbcTemplate.update(sql, cust.getCustomerNumber(), cust.getCustomerName(), cust.getContactLastName(), 
	        		cust.getContactFirstName(), cust.getPhone(), cust.getAddressLine1(), cust.getAddressLine2(), 
	        		cust.getCity(), cust.getState(), cust.getPostalCode(), cust.getCountry(), 
	        		cust.getSalesRepEmployeeNumber(), cust.getCreditLimit(), cust.getCustomerID());
	        
	    } else {
	        // insert
	    	
	    	String sql = "INSERT INTO customers (customerNumber,customerName,contactLastName,contactFirstName,phone,addressLine1,addressLine2,city,state,postalCode,country,salesRepEmployeeNumber,creditLimit)"
	                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        jdbcTemplate.update(sql, cust.getCustomerNumber(), cust.getCustomerName(), cust.getContactLastName(), 
	        		cust.getContactFirstName(), cust.getPhone(), cust.getAddressLine1(), cust.getAddressLine2(), 
	        		cust.getCity(), cust.getState(), cust.getPostalCode(), cust.getCountry(), 
	        		cust.getSalesRepEmployeeNumber(), cust.getCreditLimit());
	                
	    }
	 
    }
 
	@Override
    public void delete(int customerID) {
        // implementation details goes here...
		String sql = "DELETE FROM customers WHERE customerID=?";
		jdbcTemplate.update(sql, customerID);
    }
    
    
	@Override
	public Customer get(int customerID) {
		// TODO Auto-generated method stub
		   String sql = "SELECT * FROM customers WHERE customerID =" + customerID;
		    return jdbcTemplate.query(sql, new ResultSetExtractor<Customer>() {
		 
		        @Override
		        public Customer extractData(ResultSet rs) throws SQLException,
		                DataAccessException {
		            if (rs.next()) {
		            	Customer cust = new Customer();
		            	cust.setCustomerID(rs.getInt("customerID"));
		            	cust.setCustomerNumber(rs.getInt("customerNumber"));
		            	cust.setCustomerName(rs.getString("customerName"));
		            	cust.setContactLastName(rs.getString("contactLastName"));
		            	cust.setContactFirstName(rs.getString("contactFirstName"));
		            	cust.setPhone(rs.getString("phone"));
		            	cust.setAddressLine1(rs.getString("addressLine1"));
		            	cust.setAddressLine2(rs.getString("addressLine2"));
		            	cust.setCity(rs.getString("city"));
		            	cust.setState(rs.getString("state"));
		            	cust.setPostalCode(rs.getString("postalCode"));
		            	cust.setCountry(rs.getString("country"));
		            	cust.setSalesRepEmployeeNumber(rs.getInt("salesRepEmployeeNumber"));
		            	cust.setCreditLimit(rs.getDouble("creditLimit"));
		                return cust;
		            }
		 
		            return null;
		        }
		 
		    });
		}
		
	@Override
	public List<Customer> custList() {
		// TODO Auto-generated method stub

	    String sql = "SELECT * FROM customers";
	    List<Customer> listCustomer = jdbcTemplate.query(sql, new RowMapper<Customer>() {
	    	 
	        
	        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	Customer cust = new Customer();
            	cust.setCustomerID(rs.getInt("customerID"));
            	cust.setCustomerNumber(rs.getInt("customerNumber"));
            	cust.setCustomerName(rs.getString("customerName"));
            	cust.setContactLastName(rs.getString("contactLastName"));
            	cust.setContactFirstName(rs.getString("contactFirstName"));
            	cust.setPhone(rs.getString("phone"));
            	cust.setAddressLine1(rs.getString("addressLine1"));
            	cust.setAddressLine2(rs.getString("addressLine2"));
            	cust.setCity(rs.getString("city"));
            	cust.setState(rs.getString("state"));
            	cust.setPostalCode(rs.getString("postalCode"));
            	cust.setCountry(rs.getString("country"));
            	cust.setSalesRepEmployeeNumber(rs.getInt("salesRepEmployeeNumber"));
            	cust.setCreditLimit(rs.getDouble("creditLimit"));

	            return cust;
	        }
	    });
	 
	    return listCustomer;
	}
	
}