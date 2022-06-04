package SpringMVC.ClassicModels.controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import springDAO.TestOfficeDao;
import springModel.Office;
import springDAO.EmployeeDao;

@Controller

public class TestOfficeController {


	@Autowired
	private TestOfficeDao officeDAO;

	@Autowired
	private EmployeeDao employeeDao;

	/*
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
	
	@RequestMapping(value="/testofficeList")
	public ModelAndView listPayments(ModelAndView model) throws IOException{
	    List<Office> list = officeDAO.officeList();
	    model.addObject("listOffices", list);
	    model.setViewName("Office");
	 
	    return model;
	}
	
	@RequestMapping(value = "/newOffice", method = RequestMethod.GET)
	public ModelAndView newOffice(ModelAndView model) {
		Office newOffice = new Office();
	    model.addObject("office", newOffice);
	    model.setViewName("OfficeForm");
	    return model;
	}

	@RequestMapping(value = "/saveOffice", method = RequestMethod.POST)
	public ModelAndView saveProductLines(@ModelAttribute Office office) {
		officeDAO.saveOrUpdate(office);
	    return new ModelAndView("redirect:officeList");
	}

	@RequestMapping(value = "/deleteOffice", method = RequestMethod.GET)
	public ModelAndView deleteOffice(HttpServletRequest request) {
	    int officeId = Integer.parseInt(request.getParameter("id"));
	    officeDAO.delete(officeId);
	    return new ModelAndView("redirect:officeList");
	}


	@RequestMapping(value = "/editOffice", method = RequestMethod.GET)
	public ModelAndView editOffice(HttpServletRequest request) {
	    int officeId = Integer.parseInt(request.getParameter("id"));
	    Office office = officeDAO.get(officeId);
	    ModelAndView model = new ModelAndView("OfficeForm");
	    model.addObject("office", office);
	 
	    return model;
	} 
*/
	@RequestMapping(value = "/editOfficeByCountry", method = RequestMethod.GET)
	public ModelAndView editOfficeByCountry(HttpServletRequest request) {
	    String country = request.getParameter("id");
	    Office office = officeDAO.getOfficeByCountry(country);
	    ModelAndView model = new ModelAndView("OfficeForm");
	    model.addObject("office", office);
	 
	    return model;
	}

	@RequestMapping(value="/officeListByCountry", method = RequestMethod.GET)
	public ModelAndView listPayments(HttpServletRequest request) {
		String country = request.getParameter("id");
		List<Office> list = officeDAO.officeListByCountry(country);
		ModelAndView model = new ModelAndView("Office");
		
	    model.addObject("listOffices", list);
	    model.setViewName("Office");
	 
	    return model;
	}

}
