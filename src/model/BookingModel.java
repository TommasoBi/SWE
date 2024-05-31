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
            bookings.put(courtType, new HashMap<>());
        }
        String slot = date + " " + time;
        return !bookings.get(courtType).getOrDefault(slot, false);
    }

    public void bookSlot(String courtType, String date, String time) {
        if (!bookings.containsKey(courtType)) {
            bookings.put(courtType, new HashMap<>());
        }
        String slot = date + " " + time;
        bookings.get(courtType).put(slot, true);
    }
}

