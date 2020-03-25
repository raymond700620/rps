package com.xp.game.rps;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RPSController {

    @PostMapping("/play")
    String play(@RequestBody PlayRequest playRequest) {
        Result result = RPS.play(Throw.valueOf(playRequest.getP1().toUpperCase()),
                Throw.valueOf(playRequest.getP2().toUpperCase()));
        if (Result.P1_WINS.equals(result)) {
            return "Player 1 Wins";
        }
        else if (Result.P2_WINS.equals(result)) {
            return "Player 2 Wins";
        }
        return "Draw";
    }
}
