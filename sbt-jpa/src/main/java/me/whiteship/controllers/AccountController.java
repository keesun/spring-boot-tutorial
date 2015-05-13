package me.whiteship.controllers;

import me.whiteship.daos.AccountRepository;
import me.whiteship.domains.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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
        account.setUsername("whiteship " + new Date());
        account.setPassword("whiteship " + new Date());
        Account savedAccount = repository.save(account);
        return "ok " + savedAccount.getId();
    }

    @RequestMapping("/get/{id}")
    public String get(@PathVariable long id) {
        return repository.findOne(id).getUsername();
    }

}
