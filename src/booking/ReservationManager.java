package booking;

// SINGLETON PATTERN
// Questa classe rappresenta l'istanza singleton responsabile della gestione delle prenotazioni dei campi
public class ReservationManager {
    private static ReservationManager instance;

    private ReservationManager() {
        // Costruttore privato per evitare l'istanziazione diretta
    }

    public static ReservationManager getInstance() {
        if (instance == null) {
            instance = new ReservationManager();
        }
        return instance;
    }

/* Questo metodo simula la logica per gestire la prenotazione di un campo in un determinato orario.
In questo esempio, stampa un messaggio indicante il campo e l'orario della prenotazione.
 */
    public void makeReservation(String campo, String orario) {
        System.out.println("Prenotazione effettuata per il " + campo + " all'orario " + orario);
    }
}
