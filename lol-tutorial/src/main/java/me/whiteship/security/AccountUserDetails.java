package me.whiteship.security;

import me.whiteship.domains.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Keeun Baik
 */
public class AccountUserDetails extends User {

    private Account account;

    public AccountUserDetails(Account account) {
        super(account.getUsername(), account.getPassword(), authorities(account));
        this.account = account;
    }

    private static Collection<? extends GrantedAuthority> authorities(Account account) {
        List<SimpleGrantedAuthority> roles = new ArrayList<>();
        if (account.getRole() == Account.Role.ADMIN) {
            roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        } else {
            roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return roles;
    }

    public Account getAccount() {
        return account;
    }
}
