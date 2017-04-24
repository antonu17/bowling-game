package org.antonu.bowling.rest.config;

import org.antonu.bowling.game.BowlingGame;
import org.antonu.bowling.game.BowlingGameImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by kit on 4/24/17.
 */

@Configuration
public class AppConfig {

    @Bean
    public BowlingGame bowlingGame() {
        return new BowlingGameImpl();
    }
}
