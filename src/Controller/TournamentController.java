package Controller;

import Models.TournamentModel;
import View.TournamentView;
import tournament.TournamentStrategy;

import java.util.List;

// Controller per il torneo
public class TournamentController {
    private TournamentModel model;
    private TournamentView view;

    public TournamentController(TournamentModel model, TournamentView view) {
        this.model = model;
        this.view = view;
    }

    public void simulateTournament(TournamentStrategy strategy) {
        if (strategy == null) {
            System.out.println("Error: Tournament strategy not set.");
            return;
        }

        List<String> players = model.getPlayers();
        if (players == null || ((List<?>) players).isEmpty()) {
            System.out.println("Error: No players found for the tournament.");
            return;
        }

        strategy.planTournament(players);
    }
}
