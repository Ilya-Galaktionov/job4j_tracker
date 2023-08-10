package ru.job4j.poly;

public class Bus implements Transport {


    @Override
    public void drive() {
        System.out.println("Автобус едет.");
    }

    @Override
    public void passengers(int countPassengers) {
        System.out.println("Количество пассажиров в салоне: " + countPassengers);
    }

    @Override
    public double refuel(double fuel) {
        double priceFuel = 52.45;
        return priceFuel * fuel;
    }
}
