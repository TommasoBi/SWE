package models;

import java.util.List;

// Model per il torneo
public class TournamentModel {
    private List<String> players;

    public TournamentModel(List<String> players) {
        this.players = players;
    }

    public List<String> getPlayers() {
        return players;
    }
}

