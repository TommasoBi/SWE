import java.util.ArrayList;
import java.util.List;

// SINGLETON PATTERN
/* funzionalità di tenere traccia delle partite giocate.
nuova classe per gestire le partite giocate
e utilizzare il design pattern Singleton per garantire l'accesso a un'unica istanza di questa classe.
 */
public class MatchTracker {
    private static MatchTracker instance;
    private List<String> matches; // Esempio di struttura dati per tenere traccia delle partite giocate

    private MatchTracker() {
        matches = new ArrayList<>();
    }

    public static MatchTracker getInstance() {
        if (instance == null) {
            instance = new MatchTracker();
        }
        return instance;
    }

    public void addMatch(String playerName1, String playerName2, int setsWonByPlayer1, int setsWonByPlayer2, String matchType, String date) {
        String matchDetails = "Players: " + playerName1 + " vs " + playerName2 +
                ", Sets won: " + playerName1 + " (" + setsWonByPlayer1 + ") - " + playerName2 + " (" + setsWonByPlayer2 + ")" +
                ", Match type: " + matchType +
                ", Date: " + date;
        matches.add(matchDetails);
        System.out.println("Match added: " + matchDetails);
    }

    public List<String> getAllMatches() {
        return matches;
    }
}
