package org.jam.bookingservice.service;

import org.jam.bookingservice.dto.BookingRequest;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    public boolean bookTimeslot(BookingRequest bookingRequest) {
        // Attempt to book the timeslot.
        return true;
    }
}
