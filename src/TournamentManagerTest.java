import model.tournament.RoundRobinTournamentStrategy;
import model.tournament.TournamentManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class TournamentManagerTest {
    private TournamentManager tournamentManager;
    private RoundRobinTournamentStrategy roundRobinStrategy;
    @BeforeEach
    public void setUp() {
        tournamentManager = TournamentManager.getInstance();
        roundRobinStrategy = new RoundRobinTournamentStrategy();
        tournamentManager.setStrategy(roundRobinStrategy);
    }
    @Test
    public void testValidRoundRobinTournament() {
        List<String> players = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            players.add("Player " + i);
        }
        System.out.println("Running testValidRoundRobinTournament with 8 players");
        assertDoesNotThrow(() -> tournamentManager.planTournament(players), "Torneo valido con 8 giocatori non dovrebbe lanciare eccezioni");
    }
    @Test
    public void testInvalidRoundRobinTournament() {
        List<String> players = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            players.add("Player " + i);
        }
        System.out.println("Running testInvalidRoundRobinTournament with 7 players");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> tournamentManager.planTournament(players));
        assertEquals("Round Robin Tournament requires exactly 8 players.", exception.getMessage());
    }
}

