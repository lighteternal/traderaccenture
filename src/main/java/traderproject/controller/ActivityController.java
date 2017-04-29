package traderproject.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import traderproject.service.CustomerService;

@Controller
public class ActivityController {
	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(path = "/act", method = RequestMethod.GET)
	public String goHome(HttpServletRequest request) {
		request.setAttribute("customer", customerService.findByUsername(request.getRemoteUser()));
		return "activities";
	}

}
