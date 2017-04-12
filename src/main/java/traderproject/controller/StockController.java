package traderproject.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import traderproject.model.Account;
import traderproject.model.Activity;
import traderproject.model.Customer;
import traderproject.model.Stock;
import traderproject.service.AccountService;
import traderproject.service.ActivityService;
import traderproject.service.CustomerService;
import traderproject.service.StockService;

@Controller
public class StockController {

	@Autowired
	private StockService stockService;
	@Autowired
	private ActivityService activityService;
	@Autowired
	private CustomerService customerService;
	
	
	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "/stocks", method = { RequestMethod.GET })
	public ModelAndView showAllStocks() {
		List<Stock> stocks = stockService.findAll();
		ModelAndView model = new ModelAndView("showstocks");
		model.addObject("stocks", stocks);

		return model;
	}

	@GetMapping("/stocks/{stockID}")
	public String showStockId(@PathVariable Integer stockID, HttpServletRequest request) {
		request.setAttribute("stock", stockService.findOne(stockID));

		return "showstockid";
	}

	@RequestMapping(path = "/ordered/{stockID}", method = RequestMethod.POST)
	public ModelAndView saveOrder(WebRequest request, @PathVariable Integer stockID) {
		
		
		
		// quantity only works on Chrome!! WHY??
		Stock stock = stockService.findOne(stockID);
		stock.setSVolume(stock.getSVolume() + Integer.parseInt(request.getParameter("quantity")));
		stockService.updateStock(stockID, stock);

		Customer customer = customerService.findOne(1); //example here 
		Account account = customer.getAccount();
		// get buy/sell price for one unit TYPE is either 0 or 1 for buy/sell . Define it yourself
		Date currentDate = new Date();
		
		Activity activity = new Activity(currentDate,Integer.parseInt(request.getParameter("quantity")),stockID,Double.parseDouble(request.getParameter("price")),(byte) Integer.parseInt(request.getParameter("type"),2),account);
		activityService.save(activity);  //changed accountid to not unique, add restraint if balance>0
		account.setAcBalance(account.getAcBalance()-Double.parseDouble(request.getParameter("total")));
		accountService.updateAccount(account.getAccountID(),account);
		return new ModelAndView("orderSuccess");
	}

}
