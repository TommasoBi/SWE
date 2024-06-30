package model.tournament;

import model.Player;

import java.util.List;

// Interfaccia per le strategie di pianificazione del torneo
public interface TournamentStrategy {
    void planTournament(List<Player> players, MatchAssigner matchAssigner, List<Referee> referees);
}

