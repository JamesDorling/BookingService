package org.jam.bookingservice.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.jam.bookingservice.dto.BookingRequest;
import org.jam.bookingservice.dto.BookingResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

public interface BookingV1 {
    @PostMapping("/book")
    ResponseEntity<BookingResponse> bookTimeslot(@Valid @NotNull BookingRequest bookingRequest);
}
