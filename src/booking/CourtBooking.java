package booking;

// Implementazione concreta di prenotazione per campo in terra battuta
class ClayCourtBooking implements Booking {
    @Override
    public void book() {
        System.out.println("booking.Booking a clay court");
    }
}

// Implementazione concreta di prenotazione per campo in erba
class GrassCourtBooking implements Booking {
    @Override
    public void book() {
        System.out.println("booking.Booking a grass court");
    }
}

// Implementazione concreta di prenotazione per campo sintetico
class SyntheticCourtBooking implements Booking {
    @Override
    public void book() {
        System.out.println("booking.Booking a synthetic court");
    }
}