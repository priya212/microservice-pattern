/*
 * This class used to handle muzixNotFoundException
 */
package com.stackroute.muzixservice.exception;

public class MuzixNotFoundException extends Exception {
    private String message;

    public MuzixNotFoundException(String message) {
        this.message = message;
    }

    public MuzixNotFoundException() {

    }
}
