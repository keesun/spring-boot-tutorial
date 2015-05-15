package me.whiteship.exception;

/**
 * @author Keeun Baik
 */
public class UsernameDuplicatedException extends RuntimeException {
    public UsernameDuplicatedException(String username) {
        super(username + " is duplicated");
    }
}
