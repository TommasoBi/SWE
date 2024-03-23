
// SINGLETON PATTERN
/* gestisce il torneo utilizzando il design pattern Singleton
 e può impostare la strategia di pianificazione del torneo tramite il metodo setStrategy
 */
class TournamentManager {
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

    public void planTournament() {
        strategy.planTournament();
    }
}
