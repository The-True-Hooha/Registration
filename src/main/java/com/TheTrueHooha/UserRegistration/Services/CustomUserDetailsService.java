package com.TheTrueHooha.UserRegistration.Services;

import com.TheTrueHooha.UserRegistration.Repository.UserRepository;
import com.TheTrueHooha.UserRegistration.User.CustomUserDetails;
import com.TheTrueHooha.UserRegistration.User.UserParameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        //if statement to throw null if user does not exist
        UserParameters userParameters = userRepository.findByEmail(email);
        if (userParameters == null) {
            throw new UsernameNotFoundException("sorry, username not found in the database");
        }
        return new CustomUserDetails(userParameters);
    }
}
