package com.klever.task2;

import com.klever.task2.model.Order;
import com.klever.task2.model.impl.Cargo;
import com.klever.task2.model.impl.CargoPassenger;
import com.klever.task2.model.impl.Passenger;
import com.klever.task2.order.CreateOrder;
import com.klever.task2.order.CreateOrderImpl;

/***********************************************************************************************************************
 Условия:

 - В автопарке должны быть представлены различные виды транспорта (грузовой,пассажирский, грузопассажирский).
 - У каждого транспортного средства должны быть свои характеристики, как общие (например, год выпуска, марка и
 модель, вид используемого топлива, его расход ...), так и специфичные (например, объём кузова и грузоподъёмность
 для транспорта, перевозящего грузы, и пассажировместимость – для перевозящего пассажиров).
 - Аналогично с методами: должны быть как общие (например, заправить и отремонтировать), так и специфичные (например,
 продезинфицировать салон для автобусов и опломбировать кузов для грузовиков).
 - Грузовые автомобили должны иметь разные типы кузовов и, соответственно, разные варианты перевозимых грузов
 (например, в тентованных можно перевозить промтовары, в рефрижераторах – промтовары и скоропортящиеся продукты, в
 цистернах – жидкости и т.д.).
 - Также следует предусмотреть выполнение заказов на перевозки. Заказ должен включать начальный и конечный пункты,
 а также объём, вес и тип груза для грузоперевозок или количество пассажиров для пассажироперевозок. Должна быть
 возможность погрузить и разгрузить заказ в/из конкретной машины. У каждого транспортного средства должна быть
 возможность просмотреть свободную грузоподъёмность, объём (либо количество мест) и заказы, которые на данный момент
 загружены в машину.

 Результат разработки:
 - Объектно-ориентированное описание автопарка.
 - Требуется промоделировать работу (создать несколько транспортных средств, заправить и обслужить их,
 загрузить/разгрузить несколько заказов). В идеале –
 с использованием автоматизированного цикла.
 ***********************************************************************************************************************/

public class Main {

    public static void main(String[] args) {

        CreateOrder createOrder = new CreateOrderImpl();

        Order passengerOrder = createOrder.createOrder("Гомель", "Минск", 5);
        Passenger passengerCar = (Passenger) passengerOrder.getCar();
        System.out.println("vacant seats: " + passengerCar.getFreePassengerCapacity());

        System.out.println("---");

        Order cargoOrder = createOrder.createOrder("Гомель", "Витебск", 5, 10);
        Cargo cargoCar = (Cargo) cargoOrder.getCar();
        System.out.println("vacant capacity: " + cargoCar.getFreeCapacity());
        System.out.println("vacant volume: " + cargoCar.getFreeBodyVolume());

        System.out.println("---");

        Order cargoPassengerOrder = createOrder.createOrder("Гомель", "Витебск", 5, 10, 15);
        CargoPassenger cargoPassengerCar = (CargoPassenger) cargoPassengerOrder.getCar();
        System.out.println("vacant capacity: " + cargoPassengerCar.getFreeCapacity());
        System.out.println("vacant volume: " + cargoPassengerCar.getFreeBodyVolume());
        System.out.println("vacant seats: " + cargoPassengerCar.getFreePassengerCapacity());
    }
}