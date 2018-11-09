package com.bmwgroup.greetingservice.ports.restapi;

import com.bmwgroup.greetingservice.application.GreetingService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.Optional;

@ApplicationScoped
@Path("/")
public class GreetingController {

    @Inject
    private GreetingService greetingService;


    @GET
    @Path("/greetings")
    public String greetings(@QueryParam("name") String name) {
        return greetingService.greetings(Optional.ofNullable(name));
    }
}
