package com.dreameeapi.service.impl;

import com.dreameeapi.entity.Account;
import com.dreameeapi.repository.AccountRepository;
import com.dreameeapi.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return repository.findById(id);
    }

    @Override
    public Account save(Account account) {
        return repository.save(account);
    }

    @Override
    public void delete(Account account) {
        repository.delete(account);
    }

    @Override
    public boolean exists(Account account) {
        return repository.existsById(account.getId());
    }
}
