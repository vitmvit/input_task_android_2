package com.klever.task2.model;

import com.klever.task2.constants.FuelType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@RequiredArgsConstructor
@Setter
@Getter
public abstract class Car {

    private final LocalDate manufactureYear;
    private final String brand;
    private final String model;
    private final FuelType fuelType;
    private final double fuelConsumption;

    public void refueling() {
        System.out.println("Автотранспортное срество заправлено");
    }

    public void repair() {
        System.out.println("Произведён ремонт автотранспортного срества");
    }
}
