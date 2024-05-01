package models.tournament;

import java.util.List;

// Implementazione di una strategia di pianificazione del torneo ad eliminazione diretta
// Implementazione di una strategia di pianificazione del torneo ad eliminazione diretta
public class SingleEliminationTournamentStrategy implements TournamentStrategy {
    @Override
    public void planTournament(List<String> players) {
        // Implementa la pianificazione del torneo ad eliminazione diretta
        System.out.println("Planning Single Elimination Tournament...");
        // Implementa la simulazione del torneo ad eliminazione diretta
        SingleEliminationTournamentSimulation simulation = new SingleEliminationTournamentSimulation(players);
        simulation.simulateTournament();
    }
}


