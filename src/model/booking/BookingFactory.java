package model.booking;

import model.ClayCourtBooking;
import model.GrassCourtBooking;
import model.SyntheticCourtBooking;

// FACTORY PATTERN
/*Il metodo della factory accetterà un parametro che indica il tipo di prenotazione da creare
 e restituirà un'istanza appropriata della classe di prenotazione corrispondente
 */
public class BookingFactory {
    public static Booking createBooking(String type) {
        switch (type.toLowerCase()) {
            case "clay":
                return new ClayCourtBooking();
            case "grass":
                return new GrassCourtBooking();
            case "synthetic":
                return new SyntheticCourtBooking();
            default:
                throw new IllegalArgumentException("Invalid type: " + type);
        }
    }
}
