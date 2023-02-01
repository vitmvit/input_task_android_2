package com.klever.task2.exception;

public class UnknownTransportTypeException extends RuntimeException {

    public UnknownTransportTypeException() {
        this("Unknown transport type");
    }

    public UnknownTransportTypeException(String message) {
        super(message);
    }
}
