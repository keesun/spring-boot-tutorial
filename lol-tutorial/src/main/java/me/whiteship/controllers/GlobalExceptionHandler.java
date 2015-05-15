package me.whiteship.controllers;

import me.whiteship.exception.BasicErrorResponse;
import me.whiteship.exception.UsernameDuplicatedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Keeun Baik
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(UsernameDuplicatedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BasicErrorResponse handleUsernameDuplicatedException(Exception e) {
        return new BasicErrorResponse("username.duplicated", e.getMessage());
    }

}
