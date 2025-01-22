package org.jam.bookingservice.service;

import org.jam.bookingservice.dto.BookingRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BookingService {
    /**
     * Method for booking a timeslot.
     *
     * @param bookingRequest A DTO containing all information needed about the booking request.
     */
    public void bookTimeslot(BookingRequest bookingRequest) {
        // Check if service can be booked and book it if so

        // Send message to RabbitMQ with result

        // Win
    }
}
