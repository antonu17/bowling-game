package org.antonu.bowling.rest.config.security;

import org.antonu.bowling.rest.config.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.savedrequest.NullRequestCache;

/**
 * Created by kit on 4/25/17.
 */

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private RestAuthEntryPoint restAuthEntryPoint;
    @Autowired
    private RestAuthFilter restAuthFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .addFilterAfter(restAuthFilter, BasicAuthenticationFilter.class)
                .csrf().disable()
                .exceptionHandling()
                    .authenticationEntryPoint(restAuthEntryPoint)
                    .and()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.NEVER)
                    .and()
                .authorizeRequests()
                    .antMatchers(HttpMethod.POST, Constants.ENDPOINT_URL).permitAll()
                    .anyRequest().anonymous()
                    .and()
                .requestCache()
                    .requestCache(new NullRequestCache());
    }
}
