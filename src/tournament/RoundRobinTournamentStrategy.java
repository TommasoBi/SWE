package tournament;

import java.util.List;

// STRATEGY PATTERN
// Implementazione di una strategia di pianificazione del torneo a girone
// Implementazione di una strategia di pianificazione del torneo a girone
public class RoundRobinTournamentStrategy implements TournamentStrategy {
    @Override
    public void planTournament(List<String> players) {
        // Implementa la pianificazione del torneo a girone
        System.out.println("Planning Round Robin Tournament...");
        // Implementa la simulazione del torneo a girone
        RoundRobinTournamentSimulation simulation = new RoundRobinTournamentSimulation(players);
        simulation.simulateTournament();
    }
}

