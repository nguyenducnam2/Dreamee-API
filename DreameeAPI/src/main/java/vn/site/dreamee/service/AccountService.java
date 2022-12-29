package vn.site.dreamee.service;

import java.util.List;
import java.util.Optional;

import vn.site.dreamee.entity.*;

public interface AccountService {
	List<Account> findAll();

	Optional<Account> findById(int id);

	Account save(Account account);

	void remove(Account account);
}
