package com.klever.task2.order;

import com.klever.task2.model.Order;

public interface CreateOrder {

    Order createOrder(String startPoint, String endPoint, int passengerCount);

    Order createOrder(String startPoint, String endPoint, int volume, int weight);

    Order createOrder(String startPoint, String endPoint, int volume, int weight, int passengerCount);
}
