package traderproject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import traderproject.model.Account;
import traderproject.model.Stock;
import traderproject.repo.AccountRepo;

@Service
@Transactional
public class AccountService {

	private final AccountRepo accountRepo;

	public AccountService(AccountRepo accountRepo) {

		this.accountRepo = accountRepo;
	}

	public List<Account> findAll() {
		List<Account> accounts = new ArrayList<>();
		for (Account account : accountRepo.findAll()) {
			accounts.add(account);
		}
		return accounts;
	}

	public void save(Account account) {
		accountRepo.save(account);
	}

	public void delete(int id) {
		accountRepo.delete(id);
	}

	public void updateAccount(Integer accountId, Account account) {

		accountRepo.save(account);

	}

}
