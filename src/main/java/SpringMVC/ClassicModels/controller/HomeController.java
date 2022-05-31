package SpringMVC.ClassicModels.controller;

import java.io.IOException;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {



	/*
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
*/
	
	@RequestMapping(value="/")
	public ModelAndView listEmployee(ModelAndView model) throws IOException{
	    model.setViewName("home");
	 
	    return model;
	}
	@RequestMapping(value="/homePage")
	public ModelAndView homePage(ModelAndView model) throws IOException{
	    model.setViewName("home");
	 
	    return model;
	}
	@RequestMapping(value="/bugPage")
	public ModelAndView bugPage(ModelAndView model) throws IOException{
	    model.setViewName("BugTest");
	 
	    return model;
	}
	
}
