package analysis;

import analysis.Player;

import java.util.HashMap;
import java.util.Map;

// OBSERVER PATTERN
// Classe osservatrice
public class PlayerStatistics implements PlayerObserver {
    private Player player;
    private int totalWins;
    private int totalLosses;
    private Map<String, Integer> setsWonMap;

    public PlayerStatistics(Player player) {
        this.player = player;
        player.addObserver(this);
        this.totalWins = 0;
        this.totalLosses = 0;
        this.setsWonMap = new HashMap<>();
    }

    @Override
    public void update(Player player) {
        // Aggiorna le statistiche del giocatore
        if (player.getMatchesPlayed() > 0) {
            if (player.getName().equals("Sinner")) {
                totalWins++;
            } else {
                totalLosses++;
            }
            // Aggiorna i set vinti
            updateSetsWon(player);
        }
        System.out.println("Statistics for player " + player.getName() + ":");
        System.out.println("Matches played: " + player.getMatchesPlayed());
        System.out.println("Total wins: " + totalWins);
        System.out.println("Total losses: " + totalLosses);
        System.out.println("Sets won: " + setsWonMap.get(player.getName()));
        System.out.println();
    }

    private void updateSetsWon(Player player) {
        int setsWon = setsWonMap.getOrDefault(player.getName(), 0);
        setsWon += player.getSetsWon();
        setsWonMap.put(player.getName(), setsWon);
    }
}
