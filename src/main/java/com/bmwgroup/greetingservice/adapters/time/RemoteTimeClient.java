package com.bmwgroup.greetingservice.adapters.time;

import com.bmwgroup.greetingservice.application.TimeClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.joda.time.DateTime;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.logging.Logger;

@ApplicationScoped
public class RemoteTimeClient implements TimeClient {

    private static Logger LOG = Logger.getLogger(RemoteTimeClient.class.getName());


    @Inject
    @RestClient
    private TimeRestClient client;

    @Override
    public DateTime now() {
        LOG.fine("Requesting remote service");

        TimeResource time = client.getNow();

        return new DateTime(time.getYear(), time.getMonth(), time.getDay(), time.getHours(), time.getMinutes(), time.getSeconds());
    }
}
