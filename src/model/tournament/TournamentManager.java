package model.tournament;

import model.Player;

import java.util.List;

// SINGLETON PATTERN
/* gestisce il torneo utilizzando il design pattern Singleton
 e può impostare la strategia di pianificazione del torneo tramite il metodo setStrategy
 */
public class TournamentManager {
    private static TournamentManager instance;
    private TournamentStrategy strategy;

    private TournamentManager() {}

    public static TournamentManager getInstance() {
        if (instance == null) {
            instance = new TournamentManager();
        }
        return instance;
    }

    public void setStrategy(TournamentStrategy strategy) {
        this.strategy = strategy;
    }

    public void planTournament(List<Player> players, List<Referee> referees) {
        MatchAssigner matchAssigner = new MatchAssigner();
        strategy.planTournament(players, matchAssigner, referees);
    }
}
