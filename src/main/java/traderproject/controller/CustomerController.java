package traderproject.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import traderproject.model.Customer;
import traderproject.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/")
	public String home() {
		return "login";
	}

	@RequestMapping("/editaccount")
	public String edit(Model model) {
		model.addAttribute("customer", new Customer());
		return "editaccount";
	}

	@RequestMapping(value = "/updateCustomer", method = RequestMethod.PUT)
	public @ResponseBody String updateCustomer(@RequestBody Customer customer, HttpServletRequest request) {
		
		customerService.updateCustomer(customer.getCustomerID(), customer);
		
		return "customerUpdated";
	}

	@GetMapping("/save")
	public String saveCustomer(@RequestParam String firstName, @RequestParam String lastName,
			@RequestParam String username, @RequestParam String password) {
		Customer customer = new Customer(firstName, lastName, username, password);
		customerService.save(customer);
		return "saveview";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam int customerID) {
		customerService.delete(customerID);
		return "deleteview";
	}

}
