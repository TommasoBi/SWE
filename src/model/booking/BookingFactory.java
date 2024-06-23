package model.booking;

import model.ClayCourtBooking;
import model.GrassCourtBooking;
import model.SyntheticCourtBooking;
import java.time.LocalDate;

// FACTORY PATTERN
/*Il metodo della factory accetterà un parametro che indica il tipo di prenotazione da creare
 e restituirà un'istanza appropriata della classe di prenotazione corrispondente
 */
public class BookingFactory {
    public static Surface createBooking(String type) {
        switch (type.toLowerCase()) {
            case "clay":
                return new ClayCourtBooking(LocalDate.now().minusDays(10), "Good", LocalDate.now().plusDays(20));
            case "grass":
                return new GrassCourtBooking(LocalDate.now().minusDays(5), "Fair", LocalDate.now().plusDays(15));
            case "synthetic":
                return new SyntheticCourtBooking(LocalDate.now().minusDays(7), "Excellent", LocalDate.now().plusDays(30));
            default:
                throw new IllegalArgumentException("Invalid type: " + type);
        }
    }
}
