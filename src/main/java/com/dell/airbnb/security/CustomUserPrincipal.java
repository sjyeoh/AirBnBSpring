package com.dell.airbnb.security;

import java.util.Collection;

import com.dell.airbnb.entities.User;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial")
public class CustomUserPrincipal implements UserDetails {
    private User user;

    public CustomUserPrincipal(User user) {
        this.user = user;
    }

    @Override
    public String getUsername() {
        return user.getId().toString();
    }

    //@Override
    public String getEmail() {
        return user.getId().toString();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

}