package traderproject.controller;


import java.util.Map;

import javax.validation.Valid;

import traderproject.model.*;
import traderproject.service.*;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



@RequestMapping(value={"register"})
@Controller
public class RegisterController {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private CustomerService customerService;
	
   
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public void setDataSource(DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public Integer getlast() {
        return this.jdbcTemplate.queryForObject("select customerID from Customers ORDER BY customerID DESC LIMIT 1", Integer.class);
    }

	
	@RequestMapping(method = RequestMethod.GET)
	public String viewRegistration(Map<String, Object> model) {
		Customer customer = new Customer();		
		model.put("userForm", customer);
	
  
		return "Registration";
	}
	
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView processRegistration(@Valid @ModelAttribute("UserForm") Customer user,BindingResult result,
			Map<String, Object> model) {
			
		Customer customernea = customerService.findByUsername(user.getUsername());
		
		if(customernea != null)
		{
			
			
			 
			 String msg="<html><span style='color:red'>UserName Exists</span></html>";
			 
			 return new ModelAndView("login", "msg", msg);
			
		}
		else
		{
		
		
	 		Customer customer = new Customer(user.getUsername(),user.getPassword(),user.getEmail(), user.getBirthday());
			customerService.save(customer);
					
			/*Update Account only first time with 1000 */
			Double acBal = 1000.00;
					
			Account account = new Account(getlast(),acBal,null,getlast());
			accountService.save(account);
			
			String msg1="<html><span style='color:red'>Now You Can Login</span></html>";
			return new ModelAndView("login", "success", msg1);
			
			
		}
			
	 		
		
		
		
	}
}