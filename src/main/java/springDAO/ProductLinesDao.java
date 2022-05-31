package springDAO;

import java.util.List;

import springModel.ProductLines;

public interface ProductLinesDao {

	public List<ProductLines> productLinesList();
	
    public void saveOrUpdate(ProductLines productLines);
    
    public void delete(int productLinesId);
     
    public ProductLines get(int productLinesId);
} 