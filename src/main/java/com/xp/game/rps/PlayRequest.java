package com.xp.game.rps;

public class PlayRequest {
    String p1;
    String p2;
    public PlayRequest(String p1, String p2) {
        this.p1 = p1;
        this.p2 = p2;
    }


    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    public String getP2() {
        return p2;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }
}
