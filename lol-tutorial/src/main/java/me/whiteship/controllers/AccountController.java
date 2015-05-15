package me.whiteship.controllers;

import me.whiteship.domains.Account;
import me.whiteship.dtos.AccountDTO;
import me.whiteship.exception.UsernameDuplicatedException;
import me.whiteship.repositories.AccountRepository;
import me.whiteship.services.AccountService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Keeun Baik
 */
@RestController
public class AccountController {

    @Autowired
    AccountService service;

    @Autowired
    AccountRepository repository;

    @Autowired
    ModelMapper modelMapper;

    @RequestMapping(value = "/api/v1/accounts", method = RequestMethod.POST)
    public ResponseEntity createAccount(@RequestBody @Valid AccountDTO.Request request,
                                        BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Account account = modelMapper.map(request, Account.class);
        Account userAccount = service.createUser(account);

        AccountDTO.Response response = modelMapper.map(userAccount, AccountDTO.Response.class);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // /api/v1/accounts?size=20&page=0&sort=username,asc&q=keesun
    @RequestMapping(value = "/api/v1/accounts", method = RequestMethod.GET)
    public ResponseEntity allAccounts(@RequestParam(required = false) String q, Pageable pageable) {
        Page<Account> accounts = service.page(q, pageable);

        List<AccountDTO.Response> contents = accounts.getContent().stream()
                .map(a -> modelMapper.map(a, AccountDTO.Response.class))
                .collect(Collectors.toList());

        PageImpl<AccountDTO.Response> result =
                new PageImpl<>(contents, pageable, accounts.getTotalElements());

        return new ResponseEntity(result, HttpStatus.OK);
    }
    
}
