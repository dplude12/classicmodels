package springDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import springModel.ProductLines;

public class ProductLinesDaoImpl implements ProductLinesDao {

	private JdbcTemplate jdbcTemplate;

	public ProductLinesDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(ProductLines rec) {
        // implementation details goes here...
	    if (rec.getProductLineId() > 0) {
	        // update
	    	String sql = "UPDATE productlines SET productLine=?, textDescription=?, htmlDescription=? "
	                    + "WHERE productLineId=?";
	        jdbcTemplate.update(sql, rec.getProductLine(), rec.getTextDescription(), rec.getHtmlDescription(), rec.getProductLineId());
	        
	    } else {
	        // insert
	    	
	    	String sql = "INSERT INTO productlines (productLine, textDescription, htmlDescription)"
	                    + " VALUES (?, ?, ?)";
	        jdbcTemplate.update(sql, rec.getProductLine(), rec.getTextDescription(), rec.getHtmlDescription());
	                
	    }
	 
    }
 
	@Override
    public void delete(int productLineId) {
        // implementation details goes here...
		String sql = "DELETE FROM productlines WHERE productLineId=?";
		jdbcTemplate.update(sql, productLineId);
    }
    
    
	@Override
	public ProductLines get(int productLineId) {
		// TODO Auto-generated method stub
		   String sql = "SELECT * FROM productlines WHERE productLineId =" + productLineId;
		    return jdbcTemplate.query(sql, new ResultSetExtractor<ProductLines>() {
		 
		        @Override
		        public ProductLines extractData(ResultSet rs) throws SQLException,
		                DataAccessException {
		            if (rs.next()) {
		                ProductLines rec = new ProductLines();
						rec.setProductLineId(rs.getInt("productLineId"));
		                rec.setProductLine(rs.getString("productLine"));
						rec.setTextDescription(rs.getString("textDescription"));
						rec.setHtmlDescription(rs.getString("htmlDescription"));
		                return rec;
		            }
		 
		            return null;
		        }
		 
		    });
		}
		
	@Override
	public List<ProductLines> productLinesList() {
		// TODO Auto-generated method stub

	    String sql = "SELECT * FROM productlines";
	    List<ProductLines> listProductLines = jdbcTemplate.query(sql, new RowMapper<ProductLines>() {
	    	 
	        
	        public ProductLines mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	ProductLines rec = new ProductLines();

				rec.setProductLineId(rs.getInt("productLineId"));
                rec.setProductLine(rs.getString("productLine"));
				rec.setTextDescription(rs.getString("textDescription"));
				rec.setHtmlDescription(rs.getString("htmlDescription"));
	            return rec;
	        }
	    });
	 
	    return listProductLines;
	}

}