package com.xp.game.rps;

import org.springframework.stereotype.Repository;

@Repository
public class InMemoryRepo implements RPSRepo {
    int total = 0;

    @Override
    public int getRounds() {
        return total;
    }

    @Override
    public void addRound() {
        total++;
    }
}
