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

import springDAO.PaymentsDao;
import springModel.Payments;

@Controller
public class PaymentsController {


	@Autowired
	private PaymentsDao paymentsDAO;

	/*
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
*/
	
	@RequestMapping(value="/paymentList")
	public ModelAndView listPayments(ModelAndView model) throws IOException{
	    List<Payments> list = paymentsDAO.paymentsList();
	    model.addObject("listPayments", list);
	    model.setViewName("Payments");
	 
	    return model;
	}
	
	@RequestMapping(value = "/newPayment", method = RequestMethod.GET)
	public ModelAndView newPayment(ModelAndView model) {
		Payments newPayment = new Payments();
	    model.addObject("payment", newPayment);
	    model.setViewName("PaymentsForm");
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
}
