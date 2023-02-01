package com.klever.task2.model.adapter;

public interface PassengerChangeState {

    int getPassengerCapacity();

    void setPassengerCapacity(int count);

    int getFreePassengerCapacity();

    default void disinfection() {
        System.out.println("Санитарная обработка проведена");
    }
}
