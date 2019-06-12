/*
 * This class provide implementation for all methods present inside userService interface
 */
package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.exception.UserAlreadyExistException;
import com.stackroute.userservice.exception.UserNotFoundException;
import com.stackroute.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Value("${spring.userAlreadyExist}")
    private String userAlreadyExist;

    @Value("${spring.userNotFound}")
    private String userNotFound;
    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //This method is used to saves user
    @Override
   public User saveUser(User user) throws UserAlreadyExistException {
       if(userRepository.existsById(user.getId()))
       {
           throw  new UserAlreadyExistException(userAlreadyExist);
       }
       User savedUser=userRepository.save(user);
       if(savedUser == null)
       {
           throw new UserAlreadyExistException(userAlreadyExist);
       }
       return savedUser;
   }

   //This method is used to get all users
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //This method is used to find specific user by ID
    @Override
    public User findById(int id) throws UserNotFoundException {
       User user1 =null;
       if(userRepository.existsById(id))
       {
           user1=userRepository.findById(id).get();
           if(user1==null){
               throw new UserNotFoundException(userNotFound);
           }
       }
        return user1;
    }

    //This method is used to find specific user by firstName
    @Override
    public User findByName(String firstName) throws UserNotFoundException{
       User user=null;
       user=userRepository.findByName(firstName);
       if(user==null){
           throw new UserNotFoundException(userNotFound);
       }
       return user;
    }
}
