package springDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.core.annotation.Order;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import springModel.Orders;

public class OrderDaoImpl implements OrderDao {

	private JdbcTemplate jdbcTemplate;

	public OrderDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

/*	
	@Override
	public void saveOrUpdate(Payments rec) {
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
*/
	
	@Override
	public List<Orders> orderList() {
		// TODO Auto-generated method stub

	    String sql = "SELECT * FROM orders";
	    List<Orders> listOrders = jdbcTemplate.query(sql, new RowMapper<Orders>() {
	    	 
	        
	        public Orders mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	Orders rec = new Orders();
	        	rec.setOrderNumber(rs.getInt("orderNumber"));
	        	rec.setOrderDate(rs.getDate("orderDate"));
	        	rec.setRequiredDate(rs.getDate("requiredDate"));
	        	rec.setShippedDate(rs.getDate("shippedDate"));
	        	rec.setStatus(rs.getString("status"));
	        	rec.setComments(rs.getString("comments"));
	        	rec.setCustomerNumber(rs.getInt("customerNumber"));
	        return rec;
	        }
	    });
	 
	    return listOrders;
	}

}