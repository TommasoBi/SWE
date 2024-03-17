import java.util.List;

public class Main {
    public static void main(String[] args) {
        //1
        // Otteniamo l'istanza di ReservationManager (Singleton)
        ReservationManager authority = ReservationManager.getInstance();

        // Creiamo un comando di prenotazione per il campo "Campo1" all'orario "14:00"
        ReservationCommand order = new CourtReservationCommand(authority, "Campo1", "14:00");

        // Eseguiamo il comando
        order.execute();

        //2
        // Otteniamo l'istanza di MatchTracker (Singleton)
        MatchTracker tracker = MatchTracker.getInstance();

        // Aggiungiamo una partita al tracker
        String playerName1 = "Sinner";
        String playerName2 = "Medvedev";
        int setsWonByPlayer1 = 3;
        int setsWonByPlayer2 = 2;
        String matchType = "Singles";
        String date = "2024-01-28";

        tracker.addMatch(playerName1, playerName2, setsWonByPlayer1, setsWonByPlayer2, matchType, date);

        // Otteniamo l'elenco delle partite giocate
        List<String> matches = tracker.getAllMatches();
        System.out.println("Matches played:");
        for (String match : matches) {
            System.out.println(match);
        }

        //3
        // Creazione giocatori
        Player player1 = new Player("Sinner");
        Player player2 = new Player("Medvedev");

        // Creazione osservatori
        PlayerStatistics statistics1 = new PlayerStatistics(player1);
        PlayerStatistics statistics2 = new PlayerStatistics(player2);

        // Simulazione partite giocate
        player1.playMatch(3);
        player2.playMatch(2);
    }
}

