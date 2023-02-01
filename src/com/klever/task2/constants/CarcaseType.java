package com.klever.task2.constants;

import lombok.Getter;

public enum CarcaseType {

    BODY("B"),
    REFRIGERATOR("R"),
    TENT("T"),
    TANK("TK"),
    CONTAINER("C");

    @Getter
    private final String type;

    CarcaseType(String type) {
        this.type = type;
    }
}



