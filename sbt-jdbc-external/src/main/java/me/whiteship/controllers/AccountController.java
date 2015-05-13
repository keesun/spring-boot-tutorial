package me.whiteship.controllers;

import me.whiteship.daos.AccountRepository;
import me.whiteship.domains.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Keeun Baik
 */
@RestController
public class AccountController {

    @Autowired
    AccountRepository repository;

    @RequestMapping("/add")
    public String add() {
        Account account = new Account();
        account.setId(1l);
        account.setUsername("whiteship");
        account.setPassword("whiteship");

        repository.add(account);

        return "ok";
    }

    @RequestMapping("/get")
    public String get() {
        return repository.get(1l).getUsername();
    }

}
