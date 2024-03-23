
// STRATEGY PATTERN
// Implementazione di una strategia di pianificazione del torneo ad eliminazione diretta
class SingleEliminationTournamentStrategy implements TournamentStrategy {
    private static final SingleEliminationTournamentStrategy instance = new SingleEliminationTournamentStrategy();

    private SingleEliminationTournamentStrategy() {}

    public static SingleEliminationTournamentStrategy getInstance() {
        return instance;
    }

    @Override
    public void planTournament() {
        // Implementa la pianificazione del torneo ad eliminazione diretta
        System.out.println("Planning Single Elimination Tournament...");
    }
}
