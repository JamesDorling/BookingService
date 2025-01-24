package org.jam.bookingservice.service;

import org.jam.bookingservice.dto.BookingRequest;
import org.jam.bookingservice.exception.TimeException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;

@Component
public class TimeSanitizer {
    // Im not a massive fan of this. Maybe theres a calendar library I could use
    List<DayOfWeek> openDays = List.of(
        DayOfWeek.MONDAY,
        DayOfWeek.TUESDAY,
        DayOfWeek.WEDNESDAY,
        DayOfWeek.THURSDAY,
        DayOfWeek.FRIDAY
    );

    // Set this to 8:59 rather than 9, that way we can use .isAfter() and have 9 am be a bookable time slot
    private final LocalTime dayStart = LocalTime.of(8, 59);
    // Same for day end, one minute later so people can book up to the last minute. This wouldn't make me any friends
    private final LocalTime dayEnd = LocalTime.of(17, 1);

    public boolean sanitiseTimes(BookingRequest bookingRequest) {
        if (bookingRequest.getBookingStartTime() == null) {
            throw new TimeException("Date of payload was null.");
        }

        LocalTime bookingTime = bookingRequest.getBookingStartTime().toLocalTime();
        // Seperated if statements for useful error messages.
        if (bookingRequest.getDuration() % 15 != 0) {
            throw new TimeException("""
                Booking duration was irregular. Please make into a standard time measurement, for example
                15 minutes, 30 minutes, 45 minutes, 60 minutes.
            """);
        }
        if (!openDays.contains(bookingRequest.getBookingStartTime().getDayOfWeek())) {
            throw new TimeException("We are not open that day.");
        }
        if (!bookingTime.isAfter(dayStart) || !bookingTime.plusMinutes(bookingRequest.getDuration()).isBefore(dayEnd)) {
            throw new TimeException("Please pick a time that we are open.");
        }

        // If it gets here then no problems have occured!
        return true;
    }
}
