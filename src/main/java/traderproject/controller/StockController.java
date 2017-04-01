package traderproject.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import traderproject.model.Stock;
import traderproject.service.StockService;

@Controller
public class StockController {

	@Autowired
	private StockService stockService;

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
		// updateStock with new Volume (add quantity)
		Stock stock = stockService.findOne(stockID);
		stock.setSVolume(stock.getSVolume() + Integer.parseInt(request.getParameter("quantity")));
		stockService.updateStock(stockID, stock);

		return new ModelAndView("orderSuccess");
	}

}
