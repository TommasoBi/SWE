package model.tournament;

import java.util.List;

// Interfaccia per le strategie di pianificazione del torneo
public interface TournamentStrategy {
    void planTournament(List<String> players);
}

