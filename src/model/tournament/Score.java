package model.tournament;

import model.Match;

public class Score {
    private Match match;
    private int player1Sets;
    private int player2Sets;

    public Score(Match match, int player1Sets, int player2Sets) {
        this.match = match;
        this.player1Sets = player1Sets;
        this.player2Sets = player2Sets;
    }

    public Match getMatch() {
        return match;
    }

    public int getPlayer1Sets() {
        return player1Sets;
    }

    public int getPlayer2Sets() {
        return player2Sets;
    }
}
