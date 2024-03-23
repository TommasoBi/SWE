import java.util.ArrayList;
import java.util.List;

// Classe per la simulazione di un torneo a girone
public class RoundRobinTournamentSimulation {
    private List<String> players2;

    public RoundRobinTournamentSimulation(List<String> players) {
        this.players2 = players;
    }

    public void simulateTournament() {
        List<String> group1 = new ArrayList<>(players2.subList(0, players2.size() / 2));
        List<String> group2 = new ArrayList<>(players2.subList(players2.size() / 2, players2.size()));

        System.out.println("Group 1 Matches:");
        simulateGroup(group1);
        System.out.println();

        System.out.println("Group 2 Matches:");
        simulateGroup(group2);
        System.out.println();
    }

    private void simulateGroup(List<String> group) {
        int numPlayers = group.size();
        int numRounds = numPlayers - 1;

        for (int round = 1; round <= numRounds; round++) {
            System.out.println("Round " + round + " Matches:");
            for (int i = 0; i < numPlayers / 2; i++) {
                String player1 = group.get(i);
                String player2 = group.get(numPlayers - 1 - i);
                System.out.println(player1 + " vs " + player2);
            }
            rotateGroup(group);
            System.out.println();
        }
    }

    private void rotateGroup(List<String> group) {
        // Ruota i giocatori tranne il primo
        String lastPlayer = group.remove(group.size() - 1);
        group.add(1, lastPlayer);
    }
}
