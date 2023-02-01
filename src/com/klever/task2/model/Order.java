package com.klever.task2.model;

import com.klever.task2.constants.TransportType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {

    private TransportType transportType;
    private String startPoint;
    private String endPoint;
    private Car car;
}
