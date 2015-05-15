package me.whiteship.daos;

import me.whiteship.domains.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * @author Keeun Baik
 */
@Repository
public class AccountRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public void add(Account account) {
        jdbcTemplate.update("insert into account (id, username, password) values (?, ?, ?)",
                account.getId(), account.getUsername(), account.getPassword());
    }

    public Account get(long id) {
        return jdbcTemplate.queryForObject("select * from account where id = ?", new Object[]{id}, (rs, rowNum) -> {
            Account account = new Account();
            account.setId(rs.getLong("id"));
            account.setUsername(rs.getString("username"));
            account.setUsername(rs.getString("password"));
            return account;
        });
    }

}
