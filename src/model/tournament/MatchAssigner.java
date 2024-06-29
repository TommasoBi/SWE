package model.tournament;

import model.Match;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MatchAssigner {
    private List<Referee> referees;

    public MatchAssigner(List<Referee> referees) {
        // Ordina gli arbitri per esperienza in ordine decrescente
        this.referees = new ArrayList<>(referees);
        this.referees.sort(Comparator.comparingInt(Referee::getExperience).reversed());
    }

    public void assignReferee(Match match) {
        if (referees.isEmpty()) {
            System.out.println("No referees available for match between " + match.getPlayer1().getName() + " and " + match.getPlayer2().getName());
            return;
        }
        Referee referee = referees.get(0); // Assign the most experienced referee available
        System.out.println("Assigning " + referee.getName() + " with " + referee.getExperience() + " years of experience to match between " + match.getPlayer1().getName() + " and " + match.getPlayer2().getName());
    }

    public void scheduleMatch(Match match) {
        System.out.println("Scheduling match between " + match.getPlayer1().getName() + " and " + match.getPlayer2().getName() + " at " + match.getDateTime() + " in " + match.getLocation());
    }
}
