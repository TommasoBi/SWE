package tournament;

import java.util.List;

// Interfaccia per le strategie di pianificazione del torneo
interface TournamentStrategy {
    void planTournament(List<String> players);
}

