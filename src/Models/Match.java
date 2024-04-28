package Models;

// Classe per rappresentare una partita nel torneo ad eliminazione diretta
public class Match {
    private String player1;
    private String player2;

    public Match(String player1, String player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public String getPlayer1() {
        return player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public String getWinner() {
        // Simulazione della partita: restituisci il giocatore vincente casualmente
        return Math.random() < 0.5 ? player1 : player2;
    }
}
