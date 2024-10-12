package model;

import controller.BookingController;
import view.BookingView;
import controller.PlayerStatisticsController;
import view.PlayerStatisticsView;
import model.tournament.*;
import model.tournament.SingleEliminationTournamentStrategy;
import model.tournament.RoundRobinTournamentStrategy;


import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //1
        // Creazione del Model e della View per le prenotazioni
        BookingModel model = new BookingModel();
        BookingView view = new BookingView();

        // Creazione del Controller per le prenotazioni
        BookingController controller = new BookingController(model, view);

        // Prenotazione di un campo "Campo1" all'orario "14:00"
        controller.bookCourt("Clay", "14:00", "2024-11-10");
        controller.bookCourt("Clay", "14:00", "2024-11-10");

        //2
        // Otteniamo l'istanza di models.MatchTracker (Singleton)
        MatchTracker tracker = MatchTracker.getInstance();

        // Aggiungiamo una partita al tracker
        String playerName1 = "Sinner";
        String playerName2 = "Medvedev";
        int setsWonByPlayer1 = 3;
        int setsWonByPlayer2 = 2;
        String matchType = "Singles";
        String date = "2024-09-28";

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

        // Creazione del Model, View e Controller per le statistiche dei giocatori
        PlayerStatisticsModel model1 = new PlayerStatisticsModel();
        PlayerStatisticsView view1 = new PlayerStatisticsView();
        PlayerStatisticsController controller1 = new PlayerStatisticsController(model1, view1);
        PlayerStatisticsController controller2 = new PlayerStatisticsController(model1, view1);

        // Aggiunta dei giocatori come osservatori al Model tramite i Controller
        player1.addObserver(controller1);
        player2.addObserver(controller2);

        // Simulazione delle partite giocate
        player1.playMatch(3,true);
        player2.playMatch(2,false);

        player1.removeObserver(controller1);
        player2.removeObserver(controller2);

        //4
        List<Player> players = createPlayers();
        List<Referee> referees = createReferees();

        TournamentManager tournamentManager = TournamentManager.getInstance();

        // Single Elimination Tournament
        List<Player> playersForSingleElimination = new ArrayList<>(players);
        tournamentManager.setStrategy(new SingleEliminationTournamentStrategy());
        System.out.println("Planning Single Elimination Tournament...");
        tournamentManager.planTournament(playersForSingleElimination, referees);

        // Round Robin Tournament
        List<Player> playersForRoundRobin = new ArrayList<>(players);
        tournamentManager.setStrategy(new RoundRobinTournamentStrategy());
        System.out.println("Planning Round Robin Tournament...");
        tournamentManager.planTournament(playersForRoundRobin, referees);
    }

    private static List<Player> createPlayers() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Djokovic"));
        players.add(new Player("Sonego"));
        players.add(new Player("Sinner"));
        players.add(new Player("Zverev"));
        players.add(new Player("Berrettini"));
        players.add(new Player("Medvedev"));
        players.add(new Player("Alcaraz"));
        players.add(new Player("Rublev"));
        return players;
    }

    private static List<Referee> createReferees() {
        List<Referee> referees = new ArrayList<>();
        referees.add(new Referee("Referee 1", 10));
        referees.add(new Referee("Referee 2", 5));
        referees.add(new Referee("Referee 3", 8));
        return referees;
    }
}

