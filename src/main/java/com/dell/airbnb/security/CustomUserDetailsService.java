package com.dell.airbnb.security;

import com.dell.airbnb.entities.User;
import com.dell.airbnb.repositories.UserRepository;
import com.dell.airbnb.security.CustomUserPrincipal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * UserDetailsService
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    // have to use the name loadUserByUsername due to old naming conventions
    @Override
    public UserDetails loadUserByUsername(String username) {
        //  public UserDetails loadUserByUsername(String loginField) {
        //             User usernameUser = repository.findByUsername(loginField);
        //             User emailUser = repository.findByEmail(loginField);
            
        //             if (usernameUser != null) {
        //                 return new CustomUserPrincipal(usernameUser);
        //             } else if (emailUser != null) {
        //                 return new CustomUserPrincipal(emailUser);
        //             } else {
        //                 throw new UsernameNotFoundException(email);
        //             }
        // }
        
        User user = repository.findByName(username);

        if (user == null) {
            //throw new UsernameNotFoundException(username);
            return loadUserByEmail(username);
        }
        return new CustomUserPrincipal(user);
    }

    public UserDetails loadUserByEmail(String email) {
        User user = repository.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException(email);
        }
        return new CustomUserPrincipal(user);
    }

    public User getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = null;

        if (principal instanceof String) {
            String email = (String) principal;
            currentUser = repository.findByEmail(email);
        } else if (principal instanceof CustomUserPrincipal) {
            CustomUserPrincipal customPrincipal = (CustomUserPrincipal) principal;
            currentUser = customPrincipal.getUser();
        }
        
       return currentUser;
    }
}
