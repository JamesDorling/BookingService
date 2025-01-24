package org.jam.bookingservice.service;

import org.jam.bookingservice.dto.BookingRequest;
import org.jam.bookingservice.dto.BookingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingManager {

    @Autowired
    private TimeSanitizer timeSanitizer;
    @Autowired
    private BookingService bookingService;

    /**
     * Method for booking a timeslot.
     *
     * @param bookingRequest A DTO containing all information needed about the booking request.
     */
    public BookingResponse bookSlot(BookingRequest bookingRequest) {
        BookingResponse bookingResponse = new BookingResponse();
        // Check if service can be booked and book it if so
        bookingResponse.setApproved(approveTimeslot(bookingRequest));

        // Send message to RabbitMQ with result

        // Win
        return bookingResponse;
    }

    private boolean approveTimeslot(BookingRequest bookingRequest) {
        if (timeSanitizer.sanitiseTimes(bookingRequest)) {
            return bookingService.bookTimeslot(bookingRequest);
        }

        return false;
    }


}
