package booking;

import booking.ReservationManager;

// COMMAND PATTERN
/* Questa classe implementa l'interfaccia booking.ReservationCommand e
rappresenta un comando specifico per effettuare una prenotazione di campo.
 */
public class CourtReservationCommand implements ReservationCommand {
    private ReservationManager reservationManager;
    private String court;
    private String time;

    public CourtReservationCommand(ReservationManager reservationManager, String court, String time) {
        this.reservationManager = reservationManager;
        this.court = court;
        this.time = time;
    }

/* Il metodo execute viene chiamato per eseguire la prenotazione.
In questo caso, delega l'esecuzione al metodo makeReservation di booking.ReservationManager.
 */
    @Override
    public void execute() {
        reservationManager.makeReservation(court, time);
    }
}
