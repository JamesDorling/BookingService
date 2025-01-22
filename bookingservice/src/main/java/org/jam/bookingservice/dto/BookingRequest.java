package org.jam.bookingservice.dto;

import java.time.LocalDateTime;

public class BookingRequest {
    LocalDateTime bookingStartTime;
    int duration;
    boolean approved;
}
