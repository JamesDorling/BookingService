package org.jam.bookingservice.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jam.bookingservice.api.BookingV1;
import org.jam.bookingservice.dto.BookingRequest;
import org.jam.bookingservice.dto.BookingResponse;
import org.jam.bookingservice.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
public class BookingControllerV1 implements BookingV1 {

    @Autowired
    private final BookingService bookingService;

    @Override
    public ResponseEntity<BookingResponse> bookTimeslot(@Valid @NotNull BookingRequest bookingRequest) {
        log.debug("Received booking request! \nDetails: {}", bookingRequest);
        return new ResponseEntity<BookingResponse>(this.bookingService.bookTimeslot(bookingRequest), HttpStatus.OK);
    }
}
