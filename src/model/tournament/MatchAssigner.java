package model.tournament;

import model.Match;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class MatchAssigner {
    private final Random random = new Random();

    public void assignReferee(Match match, List<Referee> referees) {
        Referee referee = referees.get(random.nextInt(referees.size()));
        System.out.println("Assigning " + referee.getName() + " with " + referee.getExperience() + " years of experience to match between " + match.getPlayer1().getName() + " and " + match.getPlayer2().getName());
    }

    public void scheduleMatch(Match match) {
        System.out.println("Scheduling match between " + match.getPlayer1().getName() + " and " + match.getPlayer2().getName() + " at " + match.getDateTime() + " in " + match.getLocation());
    }
}
