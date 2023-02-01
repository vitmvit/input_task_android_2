package com.klever.task2.order;

import com.klever.task2.constants.TransportType;
import com.klever.task2.exception.UnknownTransportTypeException;
import com.klever.task2.fabric.CarFabric;
import com.klever.task2.fabric.CarFabricImpl;
import com.klever.task2.model.Car;
import com.klever.task2.model.Order;
import com.klever.task2.model.characteristic.CargoCharacteristic;
import com.klever.task2.model.characteristic.Characteristic;
import com.klever.task2.model.characteristic.PassengerCharacteristics;
import com.klever.task2.model.impl.Cargo;
import com.klever.task2.model.impl.CargoPassenger;
import com.klever.task2.model.impl.Passenger;

public class CreateOrderImpl implements CreateOrder {

    private final CarFabric carFabric;

    public CreateOrderImpl() {
        this.carFabric = new CarFabricImpl();
    }

    @Override
    public Order createOrder(String startPoint, String endPoint, int passengerCount) {
        Passenger car = (Passenger) carFabric.createCar(TransportType.PASSENGER, getCharacteristic(TransportType.PASSENGER, 0, 0, passengerCount));
        car.refueling();
        car.disinfection();
        return getOrder(TransportType.PASSENGER, startPoint, endPoint, car);
    }

    @Override
    public Order createOrder(String startPoint, String endPoint, int volume, int weight) {
        Cargo car = (Cargo) carFabric.createCar(TransportType.CARGO, getCharacteristic(TransportType.CARGO, volume, weight, 0));
        car.refueling();
        car.sealing();
        return getOrder(TransportType.CARGO, startPoint, endPoint, car);
    }

    @Override
    public Order createOrder(String startPoint, String endPoint, int volume, int weight, int passengerCount) {
        CargoPassenger car = (CargoPassenger) carFabric.createCar(TransportType.CARGO_PASSENGER, getCharacteristic(TransportType.CARGO_PASSENGER, volume, weight, passengerCount));
        car.refueling();
        car.disinfection();
        car.sealing();
        return getOrder(TransportType.CARGO_PASSENGER, startPoint, endPoint, car);
    }

    private Characteristic[] getCharacteristic(TransportType transportType, int volume, int weight, int passengerCount) {
        if (transportType.equals(TransportType.CARGO)) {
            CargoCharacteristic cargoCharacteristic = new CargoCharacteristic();
            cargoCharacteristic.setCapacity(weight + 5);
            cargoCharacteristic.setBodyVolume(volume + 5);
            return new Characteristic[]{cargoCharacteristic};
        } else if (transportType.equals(TransportType.PASSENGER)) {
            PassengerCharacteristics passengerCharacteristics = new PassengerCharacteristics();
            passengerCharacteristics.setCapacity(passengerCount + 5);
            return new Characteristic[]{passengerCharacteristics};
        } else if (transportType.equals(TransportType.CARGO_PASSENGER)) {
            CargoCharacteristic cargoCharacteristic = new CargoCharacteristic();
            cargoCharacteristic.setCapacity(weight + 5);
            cargoCharacteristic.setBodyVolume(volume + 5);
            PassengerCharacteristics passengerCharacteristics = new PassengerCharacteristics();
            passengerCharacteristics.setCapacity(passengerCount + 5);
            return new Characteristic[]{cargoCharacteristic, passengerCharacteristics};
        }
        throw new UnknownTransportTypeException();
    }

    private Order getOrder(TransportType transportType, String startPoint, String endPoint, Car car) {
        Order order = new Order();
        order.setTransportType(transportType);
        order.setStartPoint(startPoint);
        order.setEndPoint(endPoint);
        order.setCar(car);
        return order;
    }
}
