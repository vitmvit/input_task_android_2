package com.klever.task2.model.impl;

import com.klever.task2.constants.CarcaseType;
import com.klever.task2.constants.FuelType;
import com.klever.task2.model.Car;
import com.klever.task2.model.adapter.CargoChangeState;
import com.klever.task2.model.adapter.PassengerChangeState;
import com.klever.task2.model.characteristic.CargoCharacteristic;
import com.klever.task2.model.characteristic.PassengerCharacteristics;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CargoPassenger extends Car implements PassengerChangeState, CargoChangeState {

    private CarcaseType carcaseType;
    private PassengerCharacteristics passengerCharacteristics;
    private CargoCharacteristic cargoCharacteristic;

    public CargoPassenger(LocalDate manufactureYear, String brand, String model, FuelType fuelType, double fuelConsumption) {
        super(manufactureYear, brand, model, fuelType, fuelConsumption);
    }

    @Override
    public int getBodyVolume() {
        return cargoCharacteristic.getBodyVolume();
    }

    @Override
    public void setBodyVolume(int count) {
        cargoCharacteristic.setBodyVolume(count);
    }

    @Override
    public int getFreeBodyVolume() {
        return cargoCharacteristic.getFreeBodyVolume();
    }

    @Override
    public int getFreeCapacity() {
        return cargoCharacteristic.getFreeCapacity();
    }

    @Override
    public int getLoadCapacity() {
        return cargoCharacteristic.getCapacity();
    }

    @Override
    public void setLoadCapacity(int count) {
        cargoCharacteristic.setCapacity(count);
    }

    @Override
    public int getPassengerCapacity() {
        return passengerCharacteristics.getCapacity();
    }

    @Override
    public void setPassengerCapacity(int count) {
        passengerCharacteristics.setCapacity(count);
    }

    @Override
    public int getFreePassengerCapacity() {
        return passengerCharacteristics.getFreeCapacity();
    }
}
