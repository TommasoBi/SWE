package model.tournament;

import model.Match;
import model.Player;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// Implementazione di una strategia di pianificazione del torneo a girone
public class RoundRobinTournamentStrategy implements TournamentStrategy {
    private static final int REQUIRED_PLAYERS = 8;
    private static final int GROUP_SIZE = 4;

    @Override
    public void planTournament(List<Player> players, MatchAssigner matchAssigner, List<Referee> referees) {
        if (players.size() != REQUIRED_PLAYERS) {
            throw new IllegalArgumentException("Round Robin Tournament requires exactly " + REQUIRED_PLAYERS + " players.");
        }

        // Divide players into two groups
        List<Player> groupA = players.subList(0, GROUP_SIZE);
        List<Player> groupB = players.subList(GROUP_SIZE, REQUIRED_PLAYERS);

        List<Score> scores = new ArrayList<>();
        List<Sponsor> sponsors = createSponsors();

        // Plan matches for Group A
        planGroupMatches(groupA, "Group A", scores, matchAssigner, referees);

        // Plan matches for Group B
        planGroupMatches(groupB, "Group B", scores, matchAssigner, referees);

        printScores(scores);
        printSponsors(sponsors);
    }

    private void planGroupMatches(List<Player> group, String groupName, List<Score> scores, MatchAssigner matchAssigner, List<Referee> referees) {
        System.out.println("Planning matches for " + groupName);

        for (int i = 0; i < group.size(); i++) {
            for (int j = i + 1; j < group.size(); j++) {
                Player player1 = group.get(i);
                Player player2 = group.get(j);
                Match match = new Match(player1, player2, LocalDateTime.now().plusDays(i + j), "Court " + groupName);
                matchAssigner.assignReferee(match, referees);
                matchAssigner.scheduleMatch(match);

                // Simulate match result
                int player1SetsWon = (int) (Math.random() * 3);
                int player2SetsWon = 3 - player1SetsWon;
                Score score = new Score(match, player1SetsWon, player2SetsWon);
                scores.add(score);
            }
        }
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
