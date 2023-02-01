package com.klever.task2.constants;

import lombok.Getter;

public enum FuelType {

    DIESEL("D"),
    PETROL("P");

    @Getter
    private final String type;

    FuelType(String type) {
        this.type = type;
    }
}
