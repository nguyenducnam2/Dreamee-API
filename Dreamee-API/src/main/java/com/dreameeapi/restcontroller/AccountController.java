package com.dreameeapi.restcontroller;

import com.dreameeapi.entity.Account;
import com.dreameeapi.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private MyService<Account> service;

    @GetMapping("")
    public List<Account> findAll() {
        return service.findAll();
    }
}
