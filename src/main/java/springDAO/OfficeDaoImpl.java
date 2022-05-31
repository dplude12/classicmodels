package springDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import springModel.Office;

public class OfficeDaoImpl implements OfficeDao {

	private JdbcTemplate jdbcTemplate;

	public OfficeDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}


	@Override
	public void saveOrUpdate(Office rec) {
        // implementation details goes here...
	    if (rec.getOfficeID() > 0) {
	        // update
	    	String sql = "UPDATE offices SET officeCode=?, city=?, phone=?, addressLine1=?, addressLine2=?, state=?, country=?, postalCode=?, territory=?  "
	                    + "WHERE officeID=?";
	        jdbcTemplate.update(sql, rec.getOfficeCode(), rec.getCity(), rec.getPhone(), rec.getAddressLine1(), 
	        		rec.getAddressLine2(), rec.getState(), rec.getPostalCode(), rec.getCountry(), rec.getTerritory(),rec.getOfficeID());
	        
	    } else {
	        // insert
	    	
	    	String sql = "INSERT INTO offices (officeCode, city, phone, addressLine1, addressLine2, state, country, postalCode, territory)"
	                    + " VALUES (?, ?, ?,?, ?, ?,?, ?, ?)";
	        jdbcTemplate.update(sql, rec.getOfficeCode(), rec.getCity(), rec.getPhone(), rec.getAddressLine1(), 
	        		rec.getAddressLine2(), rec.getState(), rec.getPostalCode(), rec.getCountry(), rec.getTerritory());
	                
	    }
	 
    }
 
	@Override
    public void delete(int officeId) {
        // implementation details goes here...
		String sql = "DELETE FROM offices WHERE officeID=?";
		jdbcTemplate.update(sql, officeId);
    }
    
    
	@Override
	public Office get(int officeId) {
		// TODO Auto-generated method stub
		   String sql = "SELECT * FROM offices WHERE officeID =" + officeId;
		    return jdbcTemplate.query(sql, new ResultSetExtractor<Office>() {
		 
		        @Override
		        public Office extractData(ResultSet rs) throws SQLException,
		                DataAccessException {
		            if (rs.next()) {
		            	Office rec = new Office();
						rec.setOfficeID(rs.getInt("officeID"));
						rec.setOfficeCode(rs.getString("officeCode"));
						rec.setCity(rs.getString("city"));
						rec.setPhone(rs.getString("phone"));
						rec.setAddressLine1(rs.getString("addressLine1"));
						rec.setAddressLine2(rs.getString("addressLine2"));
						rec.setState(rs.getString("state"));
						rec.setCountry(rs.getString("country"));
						rec.setPostalCode(rs.getString("postalCode"));
						rec.setTerritory(rs.getString("territory"));
		                return rec;
		            }
		 
		            return null;
		        }
		 
		    });
		}
	
	@Override
	public List<Office> officeList() {
		// TODO Auto-generated method stub

	    String sql = "SELECT * FROM offices";
	    List<Office> listOffices = jdbcTemplate.query(sql, new RowMapper<Office>() {
	    	 
	        
	        public Office mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	Office rec = new Office();
				rec.setOfficeID(rs.getInt("officeID"));
				rec.setOfficeCode(rs.getString("officeCode"));
				rec.setCity(rs.getString("city"));
				rec.setPhone(rs.getString("phone"));
				rec.setAddressLine1(rs.getString("addressLine1"));
				rec.setAddressLine2(rs.getString("addressLine2"));
				rec.setState(rs.getString("state"));
				rec.setCountry(rs.getString("country"));
				rec.setPostalCode(rs.getString("postalCode"));
				rec.setTerritory(rs.getString("territory"));
	            return rec;
	        }
	    });
	 
	    return listOffices;
	}

}