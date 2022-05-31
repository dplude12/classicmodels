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

import springDAO.ProductDao;
import springModel.Product;

@Controller
public class ProductController {


	@Autowired
	private ProductDao productDao;

	/*
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
*/
	
	@RequestMapping(value="/productList")
	public ModelAndView listPayments(ModelAndView model) throws IOException{
	    List<Product> list = productDao.productList();
	    model.addObject("listProducts", list);
	    model.setViewName("Product");
	 
	    return model;
	}
	
	@RequestMapping(value = "/newProduct", method = RequestMethod.GET)
	public ModelAndView newPayment(ModelAndView model) {
		Product newProduct = new Product();
	    model.addObject("product", newProduct);
	    model.setViewName("ProductForm");
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
	@RequestMapping(value="/productListByProductLine")
	public ModelAndView productListByProductLine(HttpServletRequest request){
		String productLine = request.getParameter("productLine");
	    List<Product> list = productDao.productListByProductLine(productLine);
	    ModelAndView model = new ModelAndView("Product");
	    model.addObject("listProducts", list);
	    model.setViewName("Product");
	 
	    return model;
	}
	

}
