package com.klever.task2.model.characteristic;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Characteristic {

    // пассажировместимость или тоннаж (от типа транспорта)
    private int capacity;
    private int occupiedCapacity;

    public int getFreeCapacity() {
        return capacity - occupiedCapacity;
    }
}
