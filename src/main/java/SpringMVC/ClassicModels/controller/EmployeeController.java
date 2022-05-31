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

import springDAO.EmployeeDao;
import springModel.Employee;

@Controller
public class EmployeeController {


	@Autowired
	private EmployeeDao employeeDAO;

	/*
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
*/
	
	@RequestMapping(value="/employeeList")
	public ModelAndView listEmployee(ModelAndView model) throws IOException{
	    List<Employee> listEmployee = employeeDAO.empList();
	    model.addObject("listEmployee", listEmployee);
	    model.setViewName("EmployeeList");
	 
	    return model;
	}
	
	@RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
	public ModelAndView newEmployee(ModelAndView model) {
	    Employee newEmployee = new Employee();
	    model.addObject("employee", newEmployee);
	    model.setViewName("EmployeeForm");
	    return model;
	}
	
	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
	    employeeDAO.saveOrUpdate(employee);
	    return new ModelAndView("redirect:employeeList");
	}
	
	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
	public ModelAndView deleteEmployee(HttpServletRequest request) {
	    int employeeId = Integer.parseInt(request.getParameter("id"));
	    employeeDAO.delete(employeeId);
	    return new ModelAndView("redirect:employeeList");
	}

	@RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
	public ModelAndView editEmployee(HttpServletRequest request) {
	    int employeeId = Integer.parseInt(request.getParameter("id"));
	    Employee employee = employeeDAO.get(employeeId);
	    ModelAndView model = new ModelAndView("EmployeeForm");
	    model.addObject("employee", employee);
	 
	    return model;
	}
	
	//empListByOffice
		@RequestMapping(value="/empListByOffice", method = RequestMethod.GET)
		public ModelAndView listEmployeeByOffice(HttpServletRequest request){
		    String officeCode = request.getParameter("officeCode");
		    List<Employee> listEmployee = employeeDAO.empListByOffice(officeCode);
		    ModelAndView model = new ModelAndView("EmployeeList");
		    model.addObject("listEmployee", listEmployee);
		    model.setViewName("EmployeeList");
		 
		    return model;
		}
	
}
