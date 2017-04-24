package org.antonu.bowling.rest.controller;

import org.antonu.bowling.game.BowlingGame;
import org.antonu.bowling.rest.message.BowlingGameMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by kit on 4/24/17.
 */

@RestController
public class GameController {

    @Autowired
    private BowlingGame game;

    @RequestMapping("/start")
    public BowlingGameMessage start() {
        return new BowlingGameMessage(game);
    }
}
