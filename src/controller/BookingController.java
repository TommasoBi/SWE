package controller;

import model.BookingModel;
import view.BookingView;
import model.booking.Booking;
import model.booking.BookingFactory;

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
        Booking booking = BookingFactory.createBooking(courtType);
        booking.book();
        view.displayBookingConfirmation(courtType, time, date);
    }
}

