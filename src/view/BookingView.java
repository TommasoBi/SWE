package view;

// View
public class BookingView {
    public void displayBookingConfirmation(String campo, String orario, String data) {
        System.out.println("Prenotazione effettuata per il " + campo + " all'orario " + orario + " nella data " + data);
    }
    public void displayErrorMessage(String message) {
        System.out.println("Errore: " + message);
    }
}
