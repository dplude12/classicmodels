package springDAO;

import java.util.List;

import springModel.Employee;
import springModel.Office;

public interface OfficeDao {

	public List<Office> officeList();
	
    public void saveOrUpdate(Office office);

    public void delete(int officeId);
     
    public Office get(int officeId);
   
} 