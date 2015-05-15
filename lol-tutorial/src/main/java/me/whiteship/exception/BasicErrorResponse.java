package me.whiteship.exception;

import lombok.Data;

/**
 * @author Keeun Baik
 */
@Data
public class BasicErrorResponse {

    private String code;
    private String message;

    public BasicErrorResponse(String code, String message) {
        this.code = code;
        this.message = message;
    }
}

