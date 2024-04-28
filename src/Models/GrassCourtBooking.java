package Models;

import booking.Booking;

// Implementazione concreta di prenotazione per campo in erba
public class GrassCourtBooking implements Booking {
    @Override
    public void book() {
        System.out.println("booking.Booking a grass court");
    }
}
