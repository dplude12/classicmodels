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

import springDAO.CustomerDao;
import springModel.Customer;

@Controller
public class CustomerController {


	@Autowired
	private CustomerDao customerDAO;

	/*
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
*/
	
	@RequestMapping(value="/Customer")
	public ModelAndView listCustomer(ModelAndView model) throws IOException{
	    List<Customer> listCustomer = customerDAO.custList();
	    model.addObject("listCustomer", listCustomer);
	    model.setViewName("Customers");
	 
	    return model;
	}
	
	@RequestMapping(value = "/newCustomer", method = RequestMethod.GET)
	public ModelAndView newCustomer(ModelAndView model) {
	    Customer newCustomer = new Customer();
	    model.addObject("customer", newCustomer);
	    model.setViewName("CustomerForm");
	    return model;
	}
	
	@RequestMapping(value = "/saveCustomer", method = RequestMethod.POST)
	public ModelAndView saveCustomer(@ModelAttribute Customer customer) {
	    customerDAO.saveOrUpdate(customer);
	    return new ModelAndView("redirect:Customer");
	}
	
	@RequestMapping(value = "/deleteCustomer", method = RequestMethod.GET)
	public ModelAndView deleteCustomer(HttpServletRequest request) {
	    int customerId = Integer.parseInt(request.getParameter("id"));
	    customerDAO.delete(customerId);
	    return new ModelAndView("redirect:Customer");
	}

	@RequestMapping(value = "/editCustomer", method = RequestMethod.GET)
	public ModelAndView editCustomer(HttpServletRequest request) {
	    int customerId = Integer.parseInt(request.getParameter("id"));
	    Customer customer = customerDAO.get(customerId);
	    ModelAndView model = new ModelAndView("CustomerForm");
	    model.addObject("customer", customer);
	 
	    return model;
	}
}
