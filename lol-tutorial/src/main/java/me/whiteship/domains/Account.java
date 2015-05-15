package me.whiteship.domains;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Keeun Baik
 */
@Data
@Entity
public class Account {

    @Id @GeneratedValue
    private long id;

    @Column(unique = true)
    private String username;

    private String password;



    @Enumerated(EnumType.STRING)
    private Role role;

    public enum Role {
        ADMIN, USER;
    }
}
