package springDAO;

import java.util.List;

import springModel.OrderDetail;

public interface OrderDetailDao {

	public List<OrderDetail> orderDetailList();

	public List<OrderDetail> orderDetailListByOrder(int orderNumber);
	
/*    
    public void saveOrUpdate(Payments payments);

    public void delete(int productLinesId);
     
    public Payments get(int productLinesId);
*/
    
} 