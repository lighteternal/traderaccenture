package traderproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ActivityController {
	@RequestMapping(path = "/act", method = RequestMethod.GET)
	public String goHome() {
		return "activities";
	}

}
