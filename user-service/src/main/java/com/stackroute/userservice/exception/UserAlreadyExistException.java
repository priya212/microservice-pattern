/*
 * This class is used to handle userAlreadyExistException
 */
package com.stackroute.userservice.exception;

public class UserAlreadyExistException extends  Exception {
    private String message;

    public UserAlreadyExistException() {
    }

    //Handle userAlreadyExistException
    public UserAlreadyExistException(String message)
    {
        super(message);
        this.message=message;
    }
}
