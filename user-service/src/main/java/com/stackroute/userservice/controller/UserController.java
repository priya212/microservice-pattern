/*
 * This class act as a controller for user service
 */
package com.stackroute.userservice.controller;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.exception.UserAlreadyExistException;
import com.stackroute.userservice.exception.UserNotFoundException;
import com.stackroute.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value="api/v1")
public class UserController {

    private UserService userService;

    @Value("${spring.userNotFound}")
    private String userNotFound;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //This method is used to saves user
    @PostMapping("User")
    public ResponseEntity<?> saveUser(@RequestBody User user)
    {
        ResponseEntity responseEntity;
        try {
            userService.saveUser(user);
            responseEntity=new ResponseEntity<String>("Successfully created ", HttpStatus.CREATED);
        }
        catch (UserAlreadyExistException ex)
        {
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.ALREADY_REPORTED);
        }
        return  responseEntity;
    }

    //This method is used get all users
    @GetMapping("User")
    public ResponseEntity<?> getAllUsers()
    {
        return  new ResponseEntity<List<User>>(userService.getAllUsers(),HttpStatus.OK);
    }

    //This method is used find user by Id
    @GetMapping("User1/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") int id)
    {
        ResponseEntity responseEntity;
        try {
            User user=userService.findById(id);
            if(user==null){
                responseEntity=new ResponseEntity<String>(userNotFound,HttpStatus.NOT_FOUND);
            }
            else {
                responseEntity = new ResponseEntity<String>("User found", HttpStatus.OK);
            }
        }
        catch(UserNotFoundException ex)
        {
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
        return  responseEntity;
    }

    //This method is used to find user by firstName
    @GetMapping("User2/{firstName}")
    public ResponseEntity<?> findByName(@PathVariable("firstName") String firstName){
        ResponseEntity responseEntity;
        try {
            User user=userService.findByName(firstName);
            if(user==null){
                responseEntity=new ResponseEntity<String>(userNotFound,HttpStatus.NOT_FOUND);
            }
            else {
                responseEntity = new ResponseEntity<String>("User found", HttpStatus.OK);
            }
        }
        catch(UserNotFoundException ex)
        {
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
}
