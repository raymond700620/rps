package com.xp.game.rps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RPSRepoTest {
    RPSRepo repo;

    @BeforeEach
    void setup() {
        repo = new InMemoryRepo();
    }

    @Test
    void givenNoPlay_returnZeroRound() {
        assertEquals(0, repo.getRounds());
    }

    @Test
    void givenSomeRoundsPlayed_returnTotalRounds() {
        repo.addRound();
        assertEquals(1,repo.getRounds());
    }
}
