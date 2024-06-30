package model.tournament;

public class Sponsor {
    private String name;
    private double amount;

    public Sponsor(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }
}
