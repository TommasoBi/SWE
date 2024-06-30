package model.tournament;

import model.Match;
import model.Player;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Implementazione di una strategia di pianificazione del torneo a girone
public class RoundRobinTournamentStrategy implements TournamentStrategy {
    private static final int REQUIRED_PLAYERS = 8;

    @Override
    public void planTournament(List<Player> players, MatchAssigner matchAssigner, List<Referee> referees) {
        if (players.size() != REQUIRED_PLAYERS) {
            throw new IllegalArgumentException("Round Robin Tournament requires exactly " + REQUIRED_PLAYERS + " players.");
        }

        List<Score> scores = new ArrayList<>();
        List<Sponsor> sponsors = createSponsors();

        // Plan matches
        for (int i = 0; i < players.size(); i++) {
            for (int j = i + 1; j < players.size(); j++) {
                Player player1 = players.get(i);
                Player player2 = players.get(j);
                Match match = new Match(player1, player2, LocalDateTime.now().plusDays(i + j), "Court 1");
                matchAssigner.assignReferee(match, referees);
                matchAssigner.scheduleMatch(match);

                // Simulate match result
                int player1SetsWon = (int) (Math.random() * 3);
                int player2SetsWon = 3 - player1SetsWon;
                Score score = new Score(match, player1SetsWon, player2SetsWon);
                scores.add(score);
            }
        }
        printScores(scores);
        printSponsors(sponsors);
    }

    private List<Sponsor> createSponsors() {
        List<Sponsor> sponsors = new ArrayList<>();
        sponsors.add(new Sponsor("Sponsor A", 50000));
        sponsors.add(new Sponsor("Sponsor B", 30000));
        return sponsors;
    }

    private void printScores(List<Score> scores) {
        for (Score score : scores) {
            Match match = score.getMatch();
            System.out.println("Match between " + match.getPlayer1().getName() + " and " + match.getPlayer2().getName() +
                    " ended with score: " + score.getPlayer1Sets() + " - " + score.getPlayer2Sets());
        }
    }

    private void printSponsors(List<Sponsor> sponsors) {
        System.out.println("Sponsors:");
        for (Sponsor sponsor : sponsors) {
            System.out.println(sponsor.getName() + " - Amount: $" + sponsor.getAmount());
        }
    }
}
