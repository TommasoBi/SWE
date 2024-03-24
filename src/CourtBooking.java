// Implementazione concreta di prenotazione per campo in terra battuta
class ClayCourtBooking implements Booking {
    @Override
    public void book() {
        System.out.println("Booking a clay court");
    }
}

// Implementazione concreta di prenotazione per campo in erba
class GrassCourtBooking implements Booking {
    @Override
    public void book() {
        System.out.println("Booking a grass court");
    }
}

// Implementazione concreta di prenotazione per campo sintetico
class SyntheticCourtBooking implements Booking {
    @Override
    public void book() {
        System.out.println("Booking a synthetic court");
    }
}

// FACTORY PATTERN
/*Il metodo della factory accetterà un parametro che indica il tipo di prenotazione da creare
 e restituirà un'istanza appropriata della classe di prenotazione corrispondente
 */
class BookingFactory {
    public static Booking createBooking(String type) {
        switch (type.toLowerCase()) {
            case "clay":
                return new ClayCourtBooking();
            case "grass":
                return new GrassCourtBooking();
            case "synthetic":
                return new SyntheticCourtBooking();
            default:
                throw new IllegalArgumentException("Invalid booking type: " + type);
        }
    }
}
