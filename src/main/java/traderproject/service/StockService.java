package traderproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import traderproject.model.Customer;
import traderproject.model.Stock;
import traderproject.repo.StockRepo;

@Service
@Transactional
public class StockService {

	private final StockRepo stockRepo;

	public StockService(StockRepo stockRepo) {

		this.stockRepo = stockRepo;
	}

	public List<Stock> findAll() {
		List<Stock> stocks = new ArrayList<>();
		for (Stock stock : stockRepo.findAll()) {
			stocks.add(stock);
		}
		return stocks;
	}

	public void save(Stock stock) {
		stockRepo.save(stock);
	}

	public void delete(int id) {
		stockRepo.delete(id);
	}

	public Stock findOne(Integer stockID) {

		return stockRepo.findOne(stockID);
	}
	
	public void updateStock(Integer stockID, Stock stock) {
		
		stockRepo.save(stock);
	
}

}
