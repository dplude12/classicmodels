package springDAO;

import java.util.List;

import springModel.Office;

public interface TestOfficeDao {

     
    public Office get(int officeId);

    public Office getOfficeByCountry(String country);   

	public List<Office> officeListByCountry(String country);
	   
} 