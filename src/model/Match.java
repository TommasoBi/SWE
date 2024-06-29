package model;

import java.time.LocalDateTime;
// Classe per rappresentare una partita nel torneo ad eliminazione diretta
public class Match {
    private Player player1;
    private Player player2;
    private LocalDateTime dateTime;
    private String location;

    public Match(Player player1, Player player2, LocalDateTime dateTime, String location) {
        this.player1 = player1;
        this.player2 = player2;
        this.dateTime = dateTime;
        this.location = location;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getLocation() {
        return location;
    }
}
