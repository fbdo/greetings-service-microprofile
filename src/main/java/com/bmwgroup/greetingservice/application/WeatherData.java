package com.bmwgroup.greetingservice.application;


import javax.json.bind.annotation.JsonbCreator;
import javax.json.bind.annotation.JsonbProperty;

public class WeatherData {
    private double temperature;
    private String description;

    @JsonbCreator
    public WeatherData(@JsonbProperty("temperature") double temperature, @JsonbProperty("description") String description) {
        this.temperature = temperature;
        this.description = description;
    }

    public double getTemperature() {
        return temperature;
    }

    public String getDescription() {
        return description;
    }
}
