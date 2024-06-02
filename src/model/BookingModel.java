package model;

import java.util.HashMap;
import java.util.Map;

// Model
public class BookingModel {
    private Map<String, Map<String, Boolean>> bookings;

    public BookingModel() {
        bookings = new HashMap<>();
    }

    public boolean isSlotAvailable(String courtType, String date, String time) {
        if (!bookings.containsKey(courtType)) {
            return true;
        }
        Map<String, Boolean> courtBookings = bookings.get(courtType);
        return !courtBookings.containsKey(date + " " + time);
    }

    public void bookSlot(String courtType, String date, String time) {
        bookings.computeIfAbsent(courtType, k -> new HashMap<>()).put(date + " " + time, true);
    }
}

