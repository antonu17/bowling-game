package org.antonu.bowling.rest.config.security;

import org.antonu.bowling.rest.config.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by kit on 4/25/17.
 */

@Component
public class RestAuthFilter extends OncePerRequestFilter {

    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        if (!createGameRequest(request) && httpSession.isNew()) {
            this.authenticationEntryPoint.commence(request, response, new GameNotFoundException("Game not found"));
        }
        filterChain.doFilter(request, response);
    }

    private boolean createGameRequest(HttpServletRequest request) {
        return "POST".equals(request.getMethod()) && request.getRequestURI().endsWith(Constants.ENDPOINT_URL);
    }

    public AuthenticationEntryPoint getAuthenticationEntryPoint() {
        return authenticationEntryPoint;
    }

    public void setAuthenticationEntryPoint(AuthenticationEntryPoint authenticationEntryPoint) {
        this.authenticationEntryPoint = authenticationEntryPoint;
    }
}
