package org.antonu.bowling.rest.controller;

import org.antonu.bowling.game.BowlingGame;
import org.antonu.bowling.game.BowlingGameFactory;
import org.antonu.bowling.rest.GameRepository;
import org.antonu.bowling.rest.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.Collection;
import java.util.UUID;

import static org.antonu.bowling.rest.config.Constants.API_VERSION;

/**
 * Created by kit on 5/11/17.
 */

@RestController
@RequestMapping(API_VERSION + "/games")
public class GamesController implements Serializable {

    private final BowlingGameFactory bowlingGameFactory;
    private final GameRepository gameRepository;

    @Autowired
    public GamesController(BowlingGameFactory bowlingGameFactory, GameRepository gameRepository) {
        this.bowlingGameFactory = bowlingGameFactory;
        this.gameRepository = gameRepository;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public Collection<String> readGames() {
        return gameRepository.getGames().keySet();
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public Game add() {
        BowlingGame bowlingGame = bowlingGameFactory.createBowlingGame();
        String id = UUID.randomUUID().toString();
        gameRepository.getGames().put(id, bowlingGame);
        return new Game().id(id);
    }
}
