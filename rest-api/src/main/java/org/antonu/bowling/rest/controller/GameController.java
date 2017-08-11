package org.antonu.bowling.rest.controller;

import org.antonu.bowling.game.BowlingGame;
import org.antonu.bowling.rest.GameRepository;
import org.antonu.bowling.rest.config.security.GameNotFoundException;
import org.antonu.bowling.rest.message.BowlingGameMessage;
import org.antonu.bowling.rest.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import java.io.Serializable;

import static org.antonu.bowling.rest.config.Constants.API_VERSION;

/**
 * Created by kit on 4/24/17.
 */

@RestController
@RequestMapping(API_VERSION + "/game")
public class GameController implements Serializable {

    private final GameRepository gameRepository;

    @Autowired
    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @RequestMapping(value = "/{gameId}", method = RequestMethod.GET, produces = "application/json")
    public Game getGame(@PathVariable String gameId) {
        BowlingGame bowlingGame = gameRepository.getGame(gameId);
        if (bowlingGame == null) {
            throw new GameNotFoundException("Game " + gameId + " is not found");
        }
        return new Game().id(gameId);
    }

    public BowlingGameMessage toss(String gameId, Integer pins, HttpSession httpSession) {
        return null;
    }
}
