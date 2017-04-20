package traderproject.repo;


import org.springframework.data.repository.CrudRepository;
import traderproject.model.Customer;


public interface CustomerRepo extends CrudRepository<Customer, Integer> {
	public Customer findByUsername(String username);
}
