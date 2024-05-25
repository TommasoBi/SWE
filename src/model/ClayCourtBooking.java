package model;

import model.booking.Booking;

// Implementazione concreta di prenotazione per campo in terra battuta
public class ClayCourtBooking implements Booking {
    @Override
    public void book() {
        System.out.println("Booking a clay court");
    }
}

