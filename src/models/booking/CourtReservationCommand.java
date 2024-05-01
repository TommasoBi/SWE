package models.booking;

// Command pattern
public class CourtReservationCommand implements ReservationCommand {
    private String court;
    private String time;

    public CourtReservationCommand(String court, String time) {
        this.court = court;
        this.time = time;
    }

    @Override
    public void execute() {
        System.out.println("Prenotazione effettuata per il " + court + " all'orario " + time);
    }
}
