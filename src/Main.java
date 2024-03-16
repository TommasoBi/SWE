//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Otteniamo l'istanza di ReservationManager (Singleton)
        ReservationManager authority = ReservationManager.getInstance();

        // Creiamo un comando di prenotazione per il campo "Campo1" all'orario "14:00"
        ReservationCommand order = new CourtReservationCommand(authority, "Campo1", "14:00");

        // Eseguiamo il comando
        order.execute();
    }
}



