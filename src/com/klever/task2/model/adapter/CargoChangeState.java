package com.klever.task2.model.adapter;

public interface CargoChangeState {

    int getBodyVolume();

    void setBodyVolume(int count);

    int getFreeBodyVolume();

    int getFreeCapacity();

    int getLoadCapacity();

    void setLoadCapacity(int capacity);

    default void sealing() {
        System.out.println("Машина опломбирована");
    }
}
