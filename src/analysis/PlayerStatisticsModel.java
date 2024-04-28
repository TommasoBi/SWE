package analysis;

import java.util.HashMap;
import java.util.Map;

public class PlayerStatisticsModel {
    private int totalWins;
    private int totalLosses;
    private Map<String, Integer> setsWonMap;

    public PlayerStatisticsModel() {
        this.totalWins = 0;
        this.totalLosses = 0;
        this.setsWonMap = new HashMap<>();
    }

    public void updateStats(Player player) {
        if (player.getMatchesPlayed() > 0) {
            if (player.getName().equals("Sinner")) {
                totalWins++;
            } else {
                totalLosses++;
            }
            updateSetsWon(player);
        }
    }

    private void updateSetsWon(Player player) {
        int setsWon = setsWonMap.getOrDefault(player.getName(), 0);
        setsWon += player.getSetsWon();
        setsWonMap.put(player.getName(), setsWon);
    }

    public int getTotalWins() {
        return totalWins;
    }

    public int getTotalLosses() {
        return totalLosses;
    }

    public int getSetsWon(String playerName) {
        return setsWonMap.getOrDefault(playerName, 0);
    }
}

