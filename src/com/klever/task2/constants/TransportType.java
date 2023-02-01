package com.klever.task2.constants;

import lombok.Getter;

public enum TransportType {

    PASSENGER("P"),
    CARGO("C"),
    CARGO_PASSENGER("CP");

    @Getter
    private final String type;

    TransportType(String type) {
        this.type = type;
    }
}
