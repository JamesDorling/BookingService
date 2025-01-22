package org.jam.bookingservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookingControllerV1 {
    @PostMapping("/book/{month}/{day}/{hour}/{minute}")
    public ResponseEntity<String> bookTimeslot(@PathVariable int month, @PathVariable int day) {
        return new ResponseEntity<String>("success", HttpStatus.OK);
    }
}
