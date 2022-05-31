package springDAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import springModel.OrderDetail;

public class OrderDetailDaoImpl implements OrderDetailDao {

	private JdbcTemplate jdbcTemplate;

	public OrderDetailDaoImpl(DataSource dataSource) {
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
	public List<OrderDetail> orderDetailList() {
		// TODO Auto-generated method stub

	    String sql = "SELECT * FROM orderdetails";
	    List<OrderDetail> listOrderDetails = jdbcTemplate.query(sql, new RowMapper<OrderDetail>() {
	    	 
	        
	        public OrderDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	OrderDetail rec = new OrderDetail();

				rec.setOrderNumber(rs.getInt("orderNumber"));
				rec.setProductCode(rs.getString("productCode"));
				rec.setQuantityOrdered(rs.getInt("quantityOrdered"));
				rec.setPriceEach(rs.getDouble("priceEach"));
				rec.setOrderLineNumber(rs.getInt("orderLineNumber"));
				return rec;
	        }
	    });
	 
	    return listOrderDetails;
	}

	@Override
	public List<OrderDetail> orderDetailListByOrder(int orderNumber) {
		// TODO Auto-generated method stub

	    String sql = "SELECT * FROM orderdetails WHERE orderNumber=" + orderNumber + " order by orderLineNumber";
	    List<OrderDetail> listOrderDetails = jdbcTemplate.query(sql, new RowMapper<OrderDetail>() {
	    	 
	        
	        public OrderDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
	        	OrderDetail rec = new OrderDetail();

				rec.setOrderNumber(rs.getInt("orderNumber"));
				rec.setProductCode(rs.getString("productCode"));
				rec.setQuantityOrdered(rs.getInt("quantityOrdered"));
				rec.setPriceEach(rs.getDouble("priceEach"));
				rec.setOrderLineNumber(rs.getInt("orderLineNumber"));
				return rec;
	        }
	    });
	 
	    return listOrderDetails;
	}

}