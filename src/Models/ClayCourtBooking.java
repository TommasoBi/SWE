package Models;

import booking.Booking;

// Implementazione concreta di prenotazione per campo in terra battuta
public class ClayCourtBooking implements Booking {
    @Override
    public void book() {
        System.out.println("booking.Booking a clay court");
    }
}

