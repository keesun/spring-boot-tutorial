package me.whiteship.daos;

import me.whiteship.domains.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Keeun Baik
 */
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByUsername(String username);

}
