
// STRATEGY PATTERN
// Implementazione di una strategia di pianificazione del torneo a girone
class RoundRobinTournamentStrategy implements TournamentStrategy {
    private static final RoundRobinTournamentStrategy instance = new RoundRobinTournamentStrategy();

    private RoundRobinTournamentStrategy() {}

    public static RoundRobinTournamentStrategy getInstance() {
        return instance;
    }

    @Override
    public void planTournament() {
        // Implementa la pianificazione del torneo a girone
        System.out.println("Planning Round Robin Tournament...");
    }
}
