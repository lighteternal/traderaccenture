package traderproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import traderproject.model.Activity;
import traderproject.service.ActivityService;

@RestController
public class ActivityRestController {

	@Autowired
	private ActivityService activityService;

	@RequestMapping(path = "/activities", method=RequestMethod.GET )
	public List<Activity> showAllActivities() {
		return activityService.findAll();
	}

//	@GetMapping("/activity/{txID}")
//	public Activity findOne(@PathVariable("txID") int txID){
//			return activityService.findOne(txID);
//	}
//
//	@GetMapping("/activ/{customerID}")
//	public List<Activity> findbyCustomerId(@PathVariable("customerID") int customerID){
//			return activityService.findbyCustomerId(customerID);
//	}

    @RequestMapping(value = "/activ", method = RequestMethod.GET)
    @ResponseBody
    public List<Activity> findbycurrentUserName(Authentication authentication) {
        return activityService.findbyCustomerName(authentication.getName());
    
}	
}
