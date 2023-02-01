package com.klever.task2.model.characteristic;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CargoCharacteristic extends Characteristic {

    private int bodyVolume;
    private int occupiedBodyVolume;

    public int getFreeBodyVolume() {
        return bodyVolume - occupiedBodyVolume;
    }
}
