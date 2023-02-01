package com.klever.task2.model.impl;

import com.klever.task2.constants.FuelType;
import com.klever.task2.model.Car;
import com.klever.task2.model.adapter.PassengerChangeState;
import com.klever.task2.model.characteristic.PassengerCharacteristics;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Passenger extends Car implements PassengerChangeState {

    private PassengerCharacteristics characteristics;

    public Passenger(LocalDate manufactureYear, String brand, String model, FuelType fuelType, double fuelConsumption) {
        super(manufactureYear, brand, model, fuelType, fuelConsumption);
    }

    @Override
    public int getPassengerCapacity() {
        return characteristics.getCapacity();
    }

    @Override
    public void setPassengerCapacity(int count) {
        characteristics.setCapacity(count);
    }

    @Override
    public int getFreePassengerCapacity() {
        return characteristics.getFreeCapacity();
    }
}
