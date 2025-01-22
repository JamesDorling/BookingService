package org.jam.bookingservice.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.jam.bookingservice.api.BookingV1;
import org.jam.bookingservice.dto.BookingRequest;
import org.jam.bookingservice.dto.BookingResponse;
import org.jam.bookingservice.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@AllArgsConstructor
@Controller
public class BookingControllerV1 implements BookingV1 {

    private final BookingService bookingService;

    @Override
    public ResponseEntity<BookingResponse> bookTimeslot(@Valid @NotNull BookingRequest bookingRequest) {
        return new ResponseEntity<BookingResponse>(bookingService.bookTimeslot(bookingRequest), HttpStatus.OK);
    }
}
