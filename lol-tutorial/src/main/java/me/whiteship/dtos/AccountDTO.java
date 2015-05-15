package me.whiteship.dtos;

import lombok.Data;
import me.whiteship.domains.Account;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Keeun Baik
 */
public class AccountDTO {

    @Data
    public static class Request {
        @NotEmpty private String username;
        @NotEmpty private String password;
    }

    @Data
    public static class Response {
        private int id;
        private String username;
        private Account.Role role;
    }

}
