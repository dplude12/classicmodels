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

public class TestOfficeDaoImpl implements TestOfficeDao {

	private JdbcTemplate jdbcTemplate;

	public TestOfficeDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
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
	public Office getOfficeByCountry(String country) {
		// TODO Auto-generated method stub
		   String sql = "SELECT * FROM offices WHERE country = '" + country + "'";
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

	public List<Office> officeListByCountry(String country) {
		// TODO Auto-generated method stub

	    String sql = "SELECT * FROM offices WHERE country = '" + country + "'";
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