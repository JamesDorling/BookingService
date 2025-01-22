package org.jam.bookingservice.api;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.jam.bookingservice.dto.BookingRequest;
import org.jam.bookingservice.dto.BookingResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Validated
public interface BookingV1 {
    @RequestMapping(
        value = "/book",
        method = RequestMethod.POST,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        headers = "Accept=application/json"
    )
    ResponseEntity<BookingResponse> bookTimeslot(@Valid @NotNull BookingRequest bookingRequest);
}
