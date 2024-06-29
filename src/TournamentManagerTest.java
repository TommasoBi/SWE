import model.Player;
import model.tournament.Referee;
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
        List<Player> players = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            players.add(new Player("Player " + i));
        }
        List<Referee> referees = new ArrayList<>();
        referees.add(new Referee("Referee 1", 10));
        referees.add(new Referee("Referee 2", 5));
        referees.add(new Referee("Referee 3", 8));
        tournamentManager.setStrategy(new RoundRobinTournamentStrategy());
        System.out.println("Running testValidRoundRobinTournament with 8 players");
        assertDoesNotThrow(() -> tournamentManager.planTournament(players, referees), "Torneo valido con 8 giocatori non dovrebbe lanciare eccezioni");
    }
    @Test
    public void testInvalidRoundRobinTournament() {
        List<String> playerNames = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            playerNames.add("Player " + i);
        }
        List<Player> players = playerNames.stream()
                .map(Player::new)
                .toList();
        List<Referee> referees = new ArrayList<>();
        referees.add(new Referee("Referee 1", 10));
        referees.add(new Referee("Referee 2", 5));
        referees.add(new Referee("Referee 3", 8));
        TournamentManager tournamentManager = TournamentManager.getInstance();
        tournamentManager.setStrategy(new RoundRobinTournamentStrategy());
        System.out.println("Running testInvalidRoundRobinTournament with 7 players and 3 referees");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> tournamentManager.planTournament(players, referees));
        assertEquals("Round Robin Tournament requires exactly 8 players.", exception.getMessage());
    }
}

