package org.rainzha.practicalunittesting.car;

public interface Car {
    boolean needsFuel();

    double getEngineTemperature();

    void driveTo(String destination);
}