package com.dochojski.bettingservice.exception;

public class BetNotFoundException extends RuntimeException {
    public BetNotFoundException(String message) {
        super(message);
    }
}
