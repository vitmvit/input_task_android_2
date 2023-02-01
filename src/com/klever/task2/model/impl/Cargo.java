package com.klever.task2.model.impl;

import com.klever.task2.constants.CarcaseType;
import com.klever.task2.constants.FuelType;
import com.klever.task2.model.Car;
import com.klever.task2.model.adapter.CargoChangeState;
import com.klever.task2.model.characteristic.CargoCharacteristic;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Cargo extends Car implements CargoChangeState {

    private CarcaseType carcaseType;
    private CargoCharacteristic characteristics;

    public Cargo(LocalDate manufactureYear, String brand, String model, FuelType fuelType, double fuelConsumption) {
        super(manufactureYear, brand, model, fuelType, fuelConsumption);
    }

    @Override
    public int getBodyVolume() {
        return characteristics.getBodyVolume();
    }

    @Override
    public void setBodyVolume(int count) {
        characteristics.setBodyVolume(count);
    }

    @Override
    public int getFreeBodyVolume() {
        return characteristics.getFreeBodyVolume();
    }

    @Override
    public int getFreeCapacity() {
        return characteristics.getFreeCapacity();
    }

    @Override
    public int getLoadCapacity() {
        return characteristics.getCapacity();
    }

    @Override
    public void setLoadCapacity(int count) {
        characteristics.setCapacity(count);
    }

    public CarcaseType getCarcaseType() {
        return carcaseType;
    }
}
