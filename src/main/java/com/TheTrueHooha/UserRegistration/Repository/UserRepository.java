package com.TheTrueHooha.UserRegistration.Repository;

import com.TheTrueHooha.UserRegistration.User.UserParameters;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository <UserParameters, Long> {

    //method that finds a user by email
    @Query ("SELECT u FROM User u WHERE u.email = ?1")
    UserParameters findByEmail (String email);
}
