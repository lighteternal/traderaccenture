package traderproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import traderproject.model.Stock;

@Controller
public class AccountController {

	
	/*@RequestMapping(path = "/ordered/{stockID}", method = RequestMethod.POST)
	public ModelAndView saveBalance(@PathVariable Integer stockID) {
		Stock stock = stockService.findOne(stockID);

		stock.setSVolume(stock.getSVolume() + Integer.parseInt(request.getParameter("quantity")));
		stockService.updateStock(stockID, stock);

		return new ModelAndView("orderSuccess");
	}*/

}
