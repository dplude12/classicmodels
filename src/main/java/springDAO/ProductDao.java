package springDAO;

import java.util.List;

import springModel.Product;

public interface ProductDao {

	public List<Product> productList();

	public List<Product> productListByProductLine(String productLine);
	
/*    
    public void saveOrUpdate(Payments payments);

    public void delete(int productLinesId);
     
    public Payments get(int productLinesId);
*/
    
} 