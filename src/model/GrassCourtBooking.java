package model;

import model.booking.Surface;
import java.time.LocalDate;

// Implementazione concreta di prenotazione per campo in erba
public class GrassCourtBooking implements Surface {
    private LocalDate lastMowing;
    private String condition;
    private LocalDate nextMowing;

    public GrassCourtBooking(LocalDate lastMowing, String condition, LocalDate nextMowing) {
        this.lastMowing = lastMowing;
        this.condition = condition;
        this.nextMowing = nextMowing;
    }

    @Override
    public void book() {
        System.out.println("Booking a grass court");
        System.out.println("Last mowing: " + lastMowing);
        System.out.println("Condition: " + condition);
        System.out.println("Next mowing: " + nextMowing);
    }

    public void scheduleMaintenance(LocalDate date) {
        nextMowing = date;
        System.out.println("Next mowing scheduled for: " + date);
    }
}
