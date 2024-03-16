
// COMMAND PATTERN
/* Questa classe implementa l'interfaccia ReservationCommand e
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
In questo caso, delega l'esecuzione al metodo makeReservation di ReservationManager.
 */
    @Override
    public void execute() {
        reservationManager.makeReservation(court, time);
    }
}
