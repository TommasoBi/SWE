package model;

import model.booking.Surface;
import java.time.LocalDate;

// Implementazione concreta di prenotazione per campo in terra battuta
public class ClayCourtBooking implements Surface {
    private LocalDate lastMaintenance;
    private String condition;
    private LocalDate nextMaintenance;

    public ClayCourtBooking(LocalDate lastMaintenance, String condition, LocalDate nextMaintenance) {
        this.lastMaintenance = lastMaintenance;
        this.condition = condition;
        this.nextMaintenance = nextMaintenance;
    }

    @Override
    public void book() {
        System.out.println("Booking a clay court");
        System.out.println("Last maintenance: " + lastMaintenance);
        System.out.println("Condition: " + condition);
        System.out.println("Next maintenance: " + nextMaintenance);
    }

    public void scheduleMaintenance(LocalDate date) {
        nextMaintenance = date;
        System.out.println("Next maintenance scheduled for: " + date);
    }
}
