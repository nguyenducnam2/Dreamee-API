package vn.site.dreamee.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.site.dreamee.entity.Account;
import vn.site.dreamee.repository.AccountRepository;
import vn.site.dreamee.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository repository;

	@Override
	public List<Account> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Account> findById(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Account save(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove(Account account) {
		// TODO Auto-generated method stub

	}

}
