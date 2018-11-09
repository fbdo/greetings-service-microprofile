package com.bmwgroup.greetingservice.adapters.weather;

import com.bmwgroup.greetingservice.application.WeatherData;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RegisterRestClient
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface WeatherRestClient {

    @GET
    @Path("/current")
    WeatherData getCurrent();
}
