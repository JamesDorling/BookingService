package org.jam.bookingservice.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeException extends RuntimeException {
    public TimeException(String message) {
        super(message);
        log.error("Timing exception thrown! Message is: {}", message);
    }
}
