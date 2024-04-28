package tournament;

import Models.Match;

import java.util.ArrayList;
import java.util.List;


/* simula il torneo generando giocando le partite in ogni turno
fino a quando non rimane un solo vincitore.
 La simulazione viene eseguita utilizzando la simulazione casuale delle partite,
  dove il vincitore di ogni partita è determinato casualmente.
   Alla fine della simulazione, viene stampato il vincitore del torneo
 */
public class SingleEliminationTournamentSimulation {
    private List<String> players;

    public SingleEliminationTournamentSimulation(List<String> players) {
        this.players = players;
    }

    public void simulateTournament() {
        List<Match> matches = generateMatches(players);

        while (matches.size() > 1) {
            List<Match> nextRoundMatches = new ArrayList<>();
            for (int i = 0; i < matches.size(); i += 2) {
                Match match1 = matches.get(i);
                Match match2 = matches.get(i + 1);
                String winner1 = match1.getWinner();
                String winner2 = match2.getWinner();
                Match nextMatch = new Match(winner1, winner2);
                nextRoundMatches.add(nextMatch);
                System.out.println("Winner of match " + match1.getPlayer1() + " vs " + match1.getPlayer2() + ": " + winner1);
                System.out.println("Winner of match " + match2.getPlayer1() + " vs " + match2.getPlayer2() + ": " + winner2);
                System.out.println("Next match: " + winner1 + " vs " + winner2);
                System.out.println();
            }
            matches = nextRoundMatches;
        }

        System.out.println("Tournament winner: " + matches.get(0).getWinner());
    }

    private List<Match> generateMatches(List<String> players) {
        List<Match> matches = new ArrayList<>();
        for (int i = 0; i < players.size(); i += 2) {
            String player1 = players.get(i);
            String player2 = players.get(i + 1);
            Match match = new Match(player1, player2);
            matches.add(match);
        }
        return matches;
    }
}
