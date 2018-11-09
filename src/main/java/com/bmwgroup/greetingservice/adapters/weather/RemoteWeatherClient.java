package com.bmwgroup.greetingservice.adapters.weather;


import com.bmwgroup.greetingservice.adapters.time.TimeRestClient;
import com.bmwgroup.greetingservice.application.WeatherClient;
import com.bmwgroup.greetingservice.application.WeatherData;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.logging.Logger;

@ApplicationScoped
public class RemoteWeatherClient implements WeatherClient {

    private static Logger LOG = Logger.getLogger(RemoteWeatherClient.class.getName());


    @Inject
    @RestClient
    private WeatherRestClient client;


    @Override
    public WeatherData current() {
        LOG.fine("Requesting remote service");

        return client.getCurrent();
    }
}
