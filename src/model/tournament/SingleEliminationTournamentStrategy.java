package model.tournament;

import model.Match;
import model.Player;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

// Implementazione di una strategia di pianificazione del torneo ad eliminazione diretta
public class SingleEliminationTournamentStrategy implements TournamentStrategy {
    @Override
    public void planTournament(List<Player> playerNames, MatchAssigner matchAssigner, List<Referee> referees) {
        List<Score> scores = new ArrayList<>();
        List<Sponsor> sponsors = createSponsors();

        // Plan matches (simplified single elimination logic)
        while (playerNames.size() > 1) {
            List<Match> matches = new ArrayList<>();
            for (int i = 0; i < playerNames.size() / 2; i++) {
                Player player1 = playerNames.get(i * 2);
                Player player2 = playerNames.get(i * 2 + 1);
                Match match = new Match(player1, player2, LocalDateTime.now().plusDays(i), "Court 1");
                matchAssigner.assignReferee(match, referees);
                matchAssigner.scheduleMatch(match);
                matches.add(match);

                // Simulate match result
                int player1SetsWon = (int) (Math.random() * 3);
                int player2SetsWon = 3 - player1SetsWon;
                Score score = new Score(match, player1SetsWon, player2SetsWon);
                scores.add(score);

                // Dummy logic to determine winner
                if (player1SetsWon > player2SetsWon) {
                    playerNames.remove(player2);
                } else {
                    playerNames.remove(player1);
                }
            }
            // Remove losers (dummy logic for example)
            playerNames = playerNames.subList(0, playerNames.size() / 2);
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


