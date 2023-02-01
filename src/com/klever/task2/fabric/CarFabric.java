package com.klever.task2.fabric;

import com.klever.task2.constants.CarcaseType;
import com.klever.task2.constants.TransportType;
import com.klever.task2.model.Car;
import com.klever.task2.model.characteristic.Characteristic;

public interface CarFabric {

    Car createCar(TransportType transportType, Characteristic[] characteristicArray);

    Car createCar(TransportType transportType, CarcaseType carcaseType, Characteristic[] characteristicArray);
}
