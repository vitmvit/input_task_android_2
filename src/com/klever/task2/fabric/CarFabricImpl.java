package com.klever.task2.fabric;

import com.klever.task2.constants.CarcaseType;
import com.klever.task2.constants.FuelType;
import com.klever.task2.constants.TransportType;
import com.klever.task2.exception.UnknownTransportTypeException;
import com.klever.task2.model.Car;
import com.klever.task2.model.characteristic.CargoCharacteristic;
import com.klever.task2.model.characteristic.Characteristic;
import com.klever.task2.model.characteristic.PassengerCharacteristics;
import com.klever.task2.model.impl.Cargo;
import com.klever.task2.model.impl.CargoPassenger;
import com.klever.task2.model.impl.Passenger;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class CarFabricImpl implements CarFabric {

    private static final Map<TransportType, Car> CAR_MAP = new HashMap<>();

    static {
        CAR_MAP.put(TransportType.CARGO, new Cargo(LocalDate.of(2020, 7, 28), "MERSEDES", "M1", FuelType.DIESEL, 20.1));
        CAR_MAP.put(TransportType.PASSENGER, new Passenger(LocalDate.of(2021, 10, 10), "Volvo", "M1", FuelType.PETROL, 12));
        CAR_MAP.put(TransportType.CARGO_PASSENGER, new CargoPassenger(LocalDate.of(1980, 1, 1), "MAZ", "M1", FuelType.DIESEL, 15));
    }

    @Override
    public Car createCar(TransportType transportType, Characteristic[] characteristicArray) {
        return createCar(transportType, CarcaseType.BODY, characteristicArray);
    }

    @Override
    public Car createCar(TransportType transportType, CarcaseType carcaseType, Characteristic[] characteristicArray) {
        Car car = CAR_MAP.get(transportType);
        if (transportType.equals(TransportType.CARGO)) {
            Cargo cargo = (Cargo) car;
            cargo.setCharacteristics((CargoCharacteristic) characteristicArray[0]);
            cargo.setCarcaseType(carcaseType);
            return cargo;
        } else if (transportType.equals(TransportType.PASSENGER)) {
            Passenger passenger = (Passenger) car;
            passenger.setCharacteristics((PassengerCharacteristics) characteristicArray[0]);
            return passenger;
        } else if (transportType.equals(TransportType.CARGO_PASSENGER)) {
            CargoPassenger cargoPassenger = (CargoPassenger) car;
            cargoPassenger.setCarcaseType(carcaseType);
            cargoPassenger.setCargoCharacteristic((CargoCharacteristic) getCharacteristic(characteristicArray[0]));
            cargoPassenger.setPassengerCharacteristics((PassengerCharacteristics) getCharacteristic(characteristicArray[1]));
            return cargoPassenger;
        }
        throw new UnknownTransportTypeException();
    }

    private Characteristic getCharacteristic(Characteristic characteristic) {
        if (characteristic instanceof CargoCharacteristic) {
            return (CargoCharacteristic) characteristic;
        } else {
            return (PassengerCharacteristics) characteristic;
        }
    }
}
