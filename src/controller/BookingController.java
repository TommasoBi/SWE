package controller;

import model.BookingModel;
import view.BookingView;
import model.booking.Booking;
import model.booking.BookingFactory;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

// Controller
public class BookingController {
    private BookingModel model;
    private BookingView view;

    public BookingController(BookingModel model, BookingView view) {
        this.model = model;
        this.view = view;
    }

    // Metodo per eseguire la prenotazione
    public void bookCourt(String courtType, String time, String date) {
        if (!isValidDate(date)) {
            view.displayErrorMessage("Invalid date");
            return;
        }

        if (!model.isSlotAvailable(courtType, date, time)) {
            view.displayErrorMessage("Campo non disponibile");
            return;
        }

        Booking booking = BookingFactory.createBooking(courtType);
        booking.book();
        model.bookSlot(courtType, date, time);
        view.displayBookingConfirmation(courtType, time, date);
    }

    public boolean isValidDate(String date) {
        try {
            // Formato della data, ad esempio "yyyy-MM-dd"
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            // Parsing della data
            LocalDate parsedDate = LocalDate.parse(date, formatter);

            // Data odierna
            LocalDate today = LocalDate.now();

            // Data un anno nel futuro
            LocalDate oneYearFromToday = today.plusYears(1);

            // Verifica che la data non sia nel passato e non oltre un anno nel futuro
            return !parsedDate.isBefore(today) && !parsedDate.isAfter(oneYearFromToday);
        } catch (DateTimeParseException e) {
            // La data non è nel formato corretto
            return false;
        }
    }
}

