package vn.site.dreamee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.site.dreamee.entity.Account;
import vn.site.dreamee.service.AccountService;

@RestController
@RequestMapping("api/account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping("")
	public String findAll() {
		return "ádasdasd";
	}

}
