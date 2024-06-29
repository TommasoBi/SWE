package model.tournament;

import model.Match;

public class Referee {
    private String name;
    private int experience;

    public Referee(String name, int experience) {
        this.name = name;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }
}

