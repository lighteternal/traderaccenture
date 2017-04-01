package traderproject.service;

import java.util.List;
import java.util.ArrayList;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

import traderproject.model.Customer;
import traderproject.repo.CustomerRepo;

@Service
@Transactional
public class CustomerService {
	
	private final CustomerRepo customerRepo;

	public CustomerService(CustomerRepo customerRepo) {
		this.customerRepo = customerRepo;
	}

	public List<Customer> findAll(){
		List<Customer> customers=new ArrayList<>();
		for ( Customer customer:customerRepo.findAll() ){
			customers.add(customer);
		}
		return customers;
	}
	
	public void save(Customer customer){
		customerRepo.save(customer);
	}
	
	public void delete(int id){
		customerRepo.delete(id);
	}
	
	
}
