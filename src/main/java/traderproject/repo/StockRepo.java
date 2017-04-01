package traderproject.repo;

import org.springframework.data.repository.CrudRepository;

import traderproject.model.Stock;

public interface StockRepo extends CrudRepository<Stock, Integer>{

}
