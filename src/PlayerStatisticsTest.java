import model.Player;
import model.PlayerStatisticsModel;
import view.PlayerStatisticsView;
import controller.PlayerStatisticsController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerStatisticsTest {
    private Player player;
    private PlayerStatisticsModel model;
    private PlayerStatisticsView view;
    private PlayerStatisticsController controller;

    @BeforeEach
    public void setUp() {
        // Creazione del giocatore
        player = new Player("Sinner");

        // Creazione del modello, vista e controller per le statistiche dei giocatori
        model = new PlayerStatisticsModel();
        view = new PlayerStatisticsView();
        controller = new PlayerStatisticsController(model, view);

        // Aggiungere il controller come osservatore del giocatore
        player.addObserver(controller);
    }

    @Test
    public void testPlayerStatisticsUpdate() {
        // Giocatore gioca una partita e vince 3 set
        player.playMatch(3);

        // Verifica che il numero di partite giocate sia stato aggiornato
        assertEquals(1, player.getMatchesPlayed(), "Numero di partite giocate non corretto");

        // Verifica che il numero di set vinti sia stato aggiornato
        assertEquals(3, player.getSetsWon(), "Numero di set vinti non corretto");

        // Verifica che il numero totale di vittorie nel modello delle statistiche sia stato aggiornato
        assertEquals(1, model.getTotalWins(), "Numero di vittorie non corretto");

        // Verifica che il numero totale di sconfitte nel modello delle statistiche sia rimasto invariato
        assertEquals(0, model.getTotalLosses(), "Numero di sconfitte non corretto");

        // Verifica che il numero totale di set vinti per il giocatore specificato sia stato aggiornato nel modello delle statistiche
        assertEquals(3, model.getSetsWon("Sinner"), "Numero di set vinti non corretto nel modello delle statistiche");
    }
}

