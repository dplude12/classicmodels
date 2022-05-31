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

import springDAO.ProductLinesDao;
import springModel.ProductLines;

@Controller
public class ProductLinesController {


	@Autowired
	private ProductLinesDao productLinesDAO;

	/*
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
*/
	
	@RequestMapping(value="/productLinesList")
	public ModelAndView listProductLines(ModelAndView model) throws IOException{
	    List<ProductLines> list = productLinesDAO.productLinesList();
	    model.addObject("listProductLines", list);
	    model.setViewName("ProductLines");
	 
	    return model;
	}
	
	@RequestMapping(value = "/newProductLines", method = RequestMethod.GET)
	public ModelAndView newProductLines(ModelAndView model) {
		ProductLines newProductLine = new ProductLines();
	    model.addObject("productLines", newProductLine);
	    model.setViewName("ProductLinesForm");
	    return model;
	}
	
	@RequestMapping(value = "/saveProductLines", method = RequestMethod.POST)
	public ModelAndView saveProductLines(@ModelAttribute ProductLines productLines) {
		productLinesDAO.saveOrUpdate(productLines);
	    return new ModelAndView("redirect:productLinesList");
	}

	@RequestMapping(value = "/deleteProductLines", method = RequestMethod.GET)
	public ModelAndView deleteProductLines(HttpServletRequest request) {
	    int productLineId = Integer.parseInt(request.getParameter("id"));
	    productLinesDAO.delete(productLineId);
	    return new ModelAndView("redirect:productLinesList");
	}

	@RequestMapping(value = "/editProductLines", method = RequestMethod.GET)
	public ModelAndView editProductLines(HttpServletRequest request) {
	    int productLineId = Integer.parseInt(request.getParameter("id"));
	    ProductLines productLines = productLinesDAO.get(productLineId);
	    ModelAndView model = new ModelAndView("ProductLinesForm");
	    model.addObject("productLines", productLines);
	 
	    return model;
	}
}
