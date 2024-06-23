package model.booking;

import java.time.LocalDate;

// Interfaccia di prenotazione
public interface Surface {
    void book();
    void scheduleMaintenance(LocalDate date);
}
