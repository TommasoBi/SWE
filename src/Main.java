import java.util.List;
import java.util.ArrayList;

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

        //4
        // Creazione del torneo utilizzando il Singleton
        TournamentManager tournamentManager = TournamentManager.getInstance();

        // Impostazione della strategia di pianificazione del torneo
        tournamentManager.setStrategy(SingleEliminationTournamentStrategy.getInstance());

        // Pianificazione del torneo
        tournamentManager.planTournament();

        // Lista dei giocatori nel torneo
        List<String> players = new ArrayList<>();
        players.add("Djokovic");
        players.add("Sonego");
        players.add("Sinner");
        players.add("Zverev");
        players.add("Berrettini");
        players.add("Medvedev");
        players.add("Alcaraz");
        players.add("Rublev");

        // Simulazione del torneo ad eliminazione diretta
        SingleEliminationTournamentSimulation simulation = new SingleEliminationTournamentSimulation(players);
        simulation.simulateTournament();

        // Creazione del manager del torneo
        TournamentManager tournamentManager2 = TournamentManager.getInstance();

        // Impostazione della strategia del torneo a girone
        tournamentManager2.setStrategy(RoundRobinTournamentStrategy.getInstance());

        // Pianificazione del torneo
        tournamentManager2.planTournament();

        // Lista dei giocatori nel torneo
        List<String> players2 = new ArrayList<>();
        players2.add("Djokovic");
        players2.add("Sonego");
        players2.add("Sinner");
        players2.add("Zverev");
        players2.add("Berrettini");
        players2.add("Medvedev");
        players2.add("Alcaraz");
        players2.add("Rublev");

        // Simulazione del torneo a girone
        RoundRobinTournamentSimulation simulation2 = new RoundRobinTournamentSimulation(players2);
        simulation2.simulateTournament();
    }
}

