package springDAO;

import java.util.List;

import springModel.Customer;

public interface CustomerDao {

	public List<Customer> custList();
	
    public void saveOrUpdate(Customer cust);
    
    public void delete(int customerID);
     
    public Customer get(int customerID);
} 