package com.bmwgroup.greetingservice.application;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Optional;

@ApplicationScoped
public class GreetingService {

    @Inject
    private TimeClient timeClient;

    @Inject
    private WeatherClient weatherClient;

    public String greetings(Optional<String> name) {
        return appendTimeData(appendWeatherData(createBufferWithName(name))).toString();
    }

    private StringBuffer createBufferWithName(Optional<String> name) {
        StringBuffer sb = new StringBuffer("Hello");
        if (name.isPresent()) {
            sb.append(" ").append(name.get());
        }
        sb.append("!\n\n");
        return sb;
    }

    private StringBuffer appendTimeData(StringBuffer sb) {
        return sb.append("The time is ").append(timeClient.now());
    }

    private StringBuffer appendWeatherData(StringBuffer sb) {
        WeatherData current = weatherClient.current();
        return sb.append("The temperature is ")
                .append(current.getTemperature())
                .append(" celsius degrees\n")
                .append(current.getDescription())
                .append("\n");
    }
}
