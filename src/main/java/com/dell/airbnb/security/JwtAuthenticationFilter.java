package com.dell.airbnb.security;

import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dell.airbnb.constants.SecurityConstants;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;

        setFilterProcessesUrl(SecurityConstants.AUTH_LOGIN_URL);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            Map<String, String> data = mapper.readValue(request.getInputStream(), Map.class);
            //String loginField ="";
            //if(data.get("email") != null)
            //  loginField = data.get("email")
            //else if(data.get("email") != null)
            //  loginField = data.get("email")
            if (!data.get("username").equals(null)){
            return authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(data.get("username"), data.get("password")));}
            else if (!data.get("email").equals(null)){
                return authenticationManager
                        .authenticate(new UsernamePasswordAuthenticationToken(data.get("email"), data.get("password")));}
        } catch (Exception e) {
        } finally {
        }

        return null;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
            FilterChain filterChain, Authentication authentication) {
        CustomUserPrincipal principal = ((CustomUserPrincipal) authentication.getPrincipal());

        String token = JwtUtils.generateJwt(principal.getUser());

        response.addHeader(SecurityConstants.TOKEN_HEADER, SecurityConstants.TOKEN_PREFIX + token);
    }
}