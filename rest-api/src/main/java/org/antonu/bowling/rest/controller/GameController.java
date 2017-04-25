package org.antonu.bowling.rest.controller;

import org.antonu.bowling.game.BowlingGame;
import org.antonu.bowling.rest.config.Constants;
import org.antonu.bowling.rest.message.BowlingGameMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

import static org.antonu.bowling.rest.config.Constants.ENDPOINT_URL;

/**
 * Created by kit on 4/24/17.
 */

@RestController
public class GameController {

    @Autowired
    private BowlingGame game;

    @RequestMapping(value = ENDPOINT_URL, method = RequestMethod.POST, produces = "application/json")
    public BowlingGameMessage createGame(HttpSession httpSession) {
        return new BowlingGameMessage(game, httpSession.getId());
    }

    @RequestMapping(value = ENDPOINT_URL, method = RequestMethod.GET, produces = "application/json")
    public BowlingGameMessage getGame(HttpSession httpSession) {
        System.out.println(httpSession.isNew());
        return new BowlingGameMessage(game, httpSession.getId());
    }

    public BowlingGameMessage toss(String gameId, Integer pins, HttpSession httpSession) {
        return new BowlingGameMessage(game, httpSession.getId());
    }
}
