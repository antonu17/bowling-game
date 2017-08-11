package org.antonu.bowling.rest;

import lombok.Data;
import org.antonu.bowling.game.BowlingGame;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kit on 5/16/17.
 */

@Data
@Component
@Scope(value = "session",  proxyMode = ScopedProxyMode.TARGET_CLASS)
public class GameRepository implements Serializable {
    private Map<String, BowlingGame> games = new HashMap<>();

    public BowlingGame getGame(String gameId) {
        return games.entrySet().stream()
                .filter(gameEntry -> gameEntry.getKey().equals(gameId))
                .map(Map.Entry::getValue)
                .findFirst().orElse(null);
    }
}
