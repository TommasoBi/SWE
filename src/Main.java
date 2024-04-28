import Controller.BookingController;
import Models.BookingModel;
import View.BookingView;
import Models.Player;
import Controller.PlayerStatisticsController;
import Models.PlayerStatisticsModel;
import View.PlayerStatisticsView;
import booking.*;
import tournament.*;
import tournament.SingleEliminationTournamentStrategy;
import tournament.RoundRobinTournamentStrategy;


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
        controller.bookCourt("Clay", "14:00");

        // Creazione di prenotazioni utilizzando la factory
        Booking clayBooking = BookingFactory.createBooking("clay");
        clayBooking.book();

        /*booking.Booking grassBooking = booking.BookingFactory.createBooking("grass");
        grassBooking.book();

        booking.Booking syntheticBooking = booking.BookingFactory.createBooking("synthetic");
        syntheticBooking.book();*/

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

        // Creazione del Model, View e Controller per le statistiche dei giocatori
        PlayerStatisticsModel model1 = new PlayerStatisticsModel();
        PlayerStatisticsView view1 = new PlayerStatisticsView();
        PlayerStatisticsController controller1 = new PlayerStatisticsController(model1, view1);
        PlayerStatisticsController controller2 = new PlayerStatisticsController(model1, view1);

        // Aggiunta dei giocatori come osservatori al Model tramite i Controller
        player1.addObserver(controller1);
        player2.addObserver(controller2);

        // Simulazione delle partite giocate
        player1.playMatch(2); // Player 1 vince 2 set
        player2.playMatch(1); // Player 2 vince 1 set

        //4
        // Creazione del torneo ad eliminazione diretta utilizzando il Singleton
        TournamentManager tournamentManager = TournamentManager.getInstance();

        // Impostazione della strategia di pianificazione del torneo ad eliminazione diretta
        tournamentManager.setStrategy(new SingleEliminationTournamentStrategy());

        // Lista dei giocatori nel torneo ad eliminazione diretta
        List<String> players = new ArrayList<>();
        players.add("Djokovic");
        players.add("Sonego");
        players.add("Sinner");
        players.add("Zverev");
        players.add("Berrettini");
        players.add("Medvedev");
        players.add("Alcaraz");
        players.add("Rublev");

        // Pianificazione del torneo ad eliminazione diretta
        tournamentManager.planTournament(players);

        // Creazione del torneo a girone utilizzando il Singleton
        TournamentManager tournamentManager2 = TournamentManager.getInstance();

        // Impostazione della strategia del torneo a girone
        tournamentManager2.setStrategy(new RoundRobinTournamentStrategy());

        // Lista dei giocatori nel torneo a girone
        List<String> players2 = new ArrayList<>();
        players2.add("Djokovic");
        players2.add("Sonego");
        players2.add("Sinner");
        players2.add("Zverev");
        players2.add("Berrettini");
        players2.add("Medvedev");
        players2.add("Alcaraz");
        players2.add("Rublev");

        // Pianificazione del torneo a girone
        tournamentManager2.planTournament(players2);
    }
}

