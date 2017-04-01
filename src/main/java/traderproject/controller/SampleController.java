package traderproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import traderproject.service.CustomerService;

@RestController
public class SampleController {
	
	
	@Autowired
	private CustomerService customerService;
	

	@GetMapping("/hello")
	public String hello(){
		
		return "Hello world!!!";
	}
	
	@GetMapping("/all")
	public String allCustomers(){
		return customerService.findAll().toString();
	 	
	}
	
	
	
}
