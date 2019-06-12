/*
 * This class is used to handle userNotFoundException
 */
package com.stackroute.userservice.exception;

public class UserNotFoundException extends  Exception {
    private String message;

    public UserNotFoundException() {
    }
    //Handle userNotFoundException
    public UserNotFoundException(String message) {
        this.message = message;
    }
}
