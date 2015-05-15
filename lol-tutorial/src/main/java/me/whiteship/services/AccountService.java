package me.whiteship.services;

import me.whiteship.domains.Account;
import me.whiteship.exception.UsernameDuplicatedException;
import me.whiteship.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author Keeun Baik
 */
@Service
public class AccountService {

    @Autowired
    AccountRepository repository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Account createUser(Account account) {
        String username = account.getUsername();
        if (repository.findByUsername(username) != null) {
            throw new UsernameDuplicatedException(username);
        }
        account.setRole(Account.Role.USER);
        account.setPassword(passwordEncoder.encode(account.getPassword()));

        return repository.save(account);
    }

    public Page<Account> page(String q, Pageable pageable) {
        Pageable pageRequest = null;
        if (pageable.getSort() == null) {
            pageRequest = new PageRequest(pageable.getPageNumber(), pageable.getPageSize(), usernameASC());
        } else {
            pageRequest = pageable;
        }

        if (q == null) {
            return repository.findAll(pageable);
        } else {
            return repository.findByUsernameContains(q, pageable);
        }
    }

    private Sort usernameASC() {
        return new Sort(Sort.Direction.ASC, "username");
    }


}
