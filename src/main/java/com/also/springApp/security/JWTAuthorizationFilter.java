package com.also.springApp.security;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static com.also.springApp.security.SecurityConstants.HEADER_STRING;
import static com.also.springApp.security.SecurityConstants.TOKEN_PREFIX;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader((HEADER_STRING));

        if(header == null || !header.startsWith(TOKEN_PREFIX)) {
            chain.doFilter(request, response);

            return;
        }

/*
        UsernamePasswordAuthenticationToken authenticationToken = getAuthentication(request);
*/
    }
}