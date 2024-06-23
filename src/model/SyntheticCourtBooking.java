package model;

import model.booking.Surface;
import java.time.LocalDate;

// Implementazione concreta di prenotazione per campo sintetico
public class SyntheticCourtBooking implements Surface {
    private LocalDate lastCleaning;
    private String condition;
    private LocalDate nextCleaning;

    public SyntheticCourtBooking(LocalDate lastCleaning, String condition, LocalDate nextCleaning) {
        this.lastCleaning = lastCleaning;
        this.condition = condition;
        this.nextCleaning = nextCleaning;
    }

    @Override
    public void book() {
        System.out.println("Booking a synthetic court");
        System.out.println("Last cleaning: " + lastCleaning);
        System.out.println("Condition: " + condition);
        System.out.println("Next cleaning: " + nextCleaning);
    }

    public void scheduleMaintenance(LocalDate date) {
        nextCleaning = date;
        System.out.println("Next cleaning scheduled for: " + date);
    }
}
