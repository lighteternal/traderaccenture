package traderproject.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import traderproject.model.Customer;
import traderproject.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/")
	public String home(){
		return "login";
	}

	
	@GetMapping("/save")
	public String saveCustomer(@RequestParam String firstName,@RequestParam String lastName, @RequestParam String username,
			@RequestParam String password){
		Customer customer = new Customer(firstName,lastName,username,password);
		customerService.save(customer);
		return "saveview";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam int customerID){
		customerService.delete(customerID);
		return "deleteview";
	}
	
	

}
