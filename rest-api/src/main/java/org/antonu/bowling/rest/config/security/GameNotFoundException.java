package org.antonu.bowling.rest.config.security;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by kit on 4/25/17.
 */
public class GameNotFoundException extends AuthenticationException {
    public GameNotFoundException(String msg) {
        super(msg);
    }
}
