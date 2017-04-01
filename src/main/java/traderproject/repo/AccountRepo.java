package traderproject.repo;

import org.springframework.data.repository.CrudRepository;

import traderproject.model.Account;

public interface AccountRepo extends CrudRepository<Account, Integer> {

}
