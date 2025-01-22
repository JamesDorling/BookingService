package org.jam.bookingservice.service;

import org.jam.bookingservice.dto.BookingRequest;
import org.jam.bookingservice.dto.BookingResponse;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    /**
     * Method for booking a timeslot.
     *
     * @param bookingRequest A DTO containing all information needed about the booking request.
     */
    public BookingResponse bookTimeslot(BookingRequest bookingRequest) {
        // Check if service can be booked and book it if so

        // Send message to RabbitMQ with result

        // Win
        return null;
    }
}
