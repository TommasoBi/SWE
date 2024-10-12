import model.BookingModel;
import view.BookingView;
import controller.BookingController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class BookingControllerTest {
    private BookingModel model;
    private BookingView view;
    private BookingController controller;
    @BeforeEach
    public void setUp() {
        model = new BookingModel();
        view = new BookingView();
        controller = new BookingController(model, view);
    }
    @Test
    public void testValidDate() {
        // Test date valida
        assertTrue(controller.isValidDate("2024-11-25"));
        // Test date nel passato
        assertFalse(controller.isValidDate("2020-01-01"));
        // Test date oltre un anno nel futuro
        assertFalse(controller.isValidDate("2025-12-31"));
        // Test date con formato non valido
        assertFalse(controller.isValidDate("15-11-2024"));
    }
    @Test
    public void testBookingConflict() {
        // Prenotazione iniziale
        controller.bookCourt("Clay", "14:00", "2024-11-25");
        System.out.println("After first booking: " + model.isSlotAvailable("Clay", "2024-11-25", "14:00"));
        // Tentativo di prenotare lo stesso slot, dovrebbe fallire
        assertFalse(model.isSlotAvailable("Clay", "2024-11-25", "14:00"));
        controller.bookCourt("Clay", "14:00", "2024-11-25");
        assertFalse(model.isSlotAvailable("Clay", "2024-11-25", "14:00"));
    }
    @Test
    public void testBookingWithoutConflict() {
        // Prenotazione iniziale
        controller.bookCourt("Clay", "14:00", "2024-11-25");
        // Prenotazione di un altro slot, dovrebbe avere successo
        assertTrue(model.isSlotAvailable("Clay", "2024-11-25", "16:00"));
        controller.bookCourt("Clay", "16:00", "2024-11-25");
        // Verifica che entrambi gli slot siano prenotati
        assertFalse(model.isSlotAvailable("Clay", "2024-11-25", "14:00"));
        assertFalse(model.isSlotAvailable("Clay", "2024-11-25", "16:00"));
    }
}
