package org.antonu.bowling.rest.config;

import org.antonu.bowling.game.BowlingGameFactory;
import org.antonu.bowling.game.factory.StandardBowlingGameFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * Created by kit on 4/24/17.
 */

@Configuration
public class AppConfig {

    @Bean
    public BowlingGameFactory bowlingGameFactory() {
        return new StandardBowlingGameFactory();
    }
}
