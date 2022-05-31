package SpringMVC.ClassicModels.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import springDAO.OrderDetailDao;
import springModel.OrderDetail;

@Controller
public class OrderDetailController {


	@Autowired
	private OrderDetailDao orderDetailDAO;

	/*
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
*/
	
	@RequestMapping(value="/orderDetailList")
	public ModelAndView listOrderDetails(ModelAndView model) throws IOException{
	    List<OrderDetail> list = orderDetailDAO.orderDetailList();
	    model.addObject("listOrderDetail", list);
	    model.setViewName("OrderDetails");
	    return model;
	}
	
	@RequestMapping(value = "/newOrderDetail", method = RequestMethod.GET)
	public ModelAndView newOrderDetail(ModelAndView model) {
		OrderDetail newOrderDetail = new OrderDetail();
	    model.addObject("orderDetail", newOrderDetail);
	    model.setViewName("OrderDetailForm");
	    return model;
	}
/*	
	@RequestMapping(value = "/savePayment", method = RequestMethod.POST)
	public ModelAndView saveProductLines(@ModelAttribute Payments payment) {
		paymentsDAO.saveOrUpdate(payment);
	    return new ModelAndView("redirect:productLinesList");
	}

	@RequestMapping(value = "/deletePayment", method = RequestMethod.GET)
	public ModelAndView deleteProductLines(HttpServletRequest request) {
	    int productLineId = Integer.parseInt(request.getParameter("id"));
	    paymentsDAO.delete(paymentsId, ID2);
	    return new ModelAndView("redirect:paymentsList");
	}

	@RequestMapping(value = "/editPayment", method = RequestMethod.GET)
	public ModelAndView editProductLines(HttpServletRequest request) {
	    int productLineId = Integer.parseInt(request.getParameter("id"));
	    Payments payment = paymentsDAO.get(productLineId);
	    ModelAndView model = new ModelAndView("ProductLinesForm");
	    model.addObject("payment", payment);
	 
	    return model;
	}
	
*/
	
	//empListByOffice
		@RequestMapping(value="/orderDetailListByOrder", method = RequestMethod.GET)
		public ModelAndView listOrderDetailListByOrder(HttpServletRequest request){
		    int orderNumber = Integer.parseInt(request.getParameter("orderNumber"));
		    List<OrderDetail> listEmployee = orderDetailDAO.orderDetailListByOrder(orderNumber);
		    ModelAndView model = new ModelAndView("OrderDetails");
		    model.addObject("listOrderDetail", listEmployee);
		    model.setViewName("OrderDetails");
		 
		    return model;
		}
	
}
