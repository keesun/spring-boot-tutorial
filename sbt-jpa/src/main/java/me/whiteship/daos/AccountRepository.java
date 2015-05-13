package me.whiteship.daos;

import me.whiteship.domains.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Keeun Baik
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {


}
