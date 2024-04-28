package Models;

import booking.Booking;

// Implementazione concreta di prenotazione per campo sintetico
public class SyntheticCourtBooking implements Booking {
    @Override
    public void book() {
        System.out.println("booking.Booking a synthetic court");
    }
}
