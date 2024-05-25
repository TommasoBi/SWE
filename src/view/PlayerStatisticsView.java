package view;

import model.Player;
import model.PlayerStatisticsModel;

public class PlayerStatisticsView {
    public void displayStats(PlayerStatisticsModel model, Player player) {
        System.out.println("Statistics for player " + player.getName() + ":");
        System.out.println("Matches played: " + player.getMatchesPlayed());
        System.out.println("Total wins: " + model.getTotalWins());
        System.out.println("Total losses: " + model.getTotalLosses());
        System.out.println("Sets won: " + model.getSetsWon(player.getName()));
        System.out.println();
    }
}
