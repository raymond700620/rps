package com.xp.game.rps;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RPSTest {


    //1. Test based on the different cases
    @Test
    void rockVsScissors() {
        assertEquals(Result.P1_WINS, RPS.play(Throw.ROCK, Throw.SCISSORS));
    }

    @Test
    void scissorsVsRock() {
        assertEquals(Result.P2_WINS, RPS.play(Throw.SCISSORS, Throw.ROCK));
    }

    @Test
    void scissorsVsPaper() {
        assertEquals(Result.P1_WINS, RPS.play(Throw.SCISSORS, Throw.PAPER));
    }

    @Test
    void scissorsVsScissor() {
        assertEquals(Result.DRAW, RPS.play(Throw.SCISSORS, Throw.SCISSORS));
    }

    //Group testing together --> Refactor
    @Test
    void case_DRAW() {
        assertEquals(Result.DRAW, RPS.play(Throw.SCISSORS,Throw.SCISSORS));
        assertEquals(Result.DRAW, RPS.play(Throw.PAPER,Throw.PAPER));
        assertEquals(Result.DRAW, RPS.play(Throw.ROCK,Throw.ROCK));
    }

    @Test
    void case_P1_WIN() {
        assertEquals(Result.P1_WINS, RPS.play(Throw.ROCK, Throw.SCISSORS));
        assertEquals(Result.P1_WINS, RPS.play(Throw.PAPER, Throw.ROCK));
        assertEquals(Result.P1_WINS, RPS.play(Throw.SCISSORS, Throw.PAPER));
    }

    @Test
    void case_P2_WIN() {
        assertEquals(Result.P2_WINS, RPS.play( Throw.SCISSORS,Throw.ROCK));
        assertEquals(Result.P2_WINS, RPS.play( Throw.ROCK,Throw.PAPER));
        assertEquals(Result.P2_WINS, RPS.play( Throw.PAPER,Throw.SCISSORS));
    }

}
