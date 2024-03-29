/*
 * This interface is act as a repository for user service
 */
package com.stackroute.userservice.repository;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.exception.UserNotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    //SQL query to fetch specific user by firstName
    @Query("select u from User u where u.firstName=:firstName")
    public User findByName(@Param("firstName") String firstName) throws UserNotFoundException;
}
