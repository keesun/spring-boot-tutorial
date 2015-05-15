package me.whiteship.repositories;

import me.whiteship.domains.Account;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Keeun Baik
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByUsername(String username);

    Page<Account> findByUsernameContains(String q, Pageable pageable);
}
