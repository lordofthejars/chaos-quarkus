package org.acme;

import java.time.temporal.ChronoUnit;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.faulttolerance.ExecutionContext;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.FallbackHandler;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/hello")
@RegisterRestClient
public interface ProviderService {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Retry(maxRetries = 10, delay = 500, delayUnit = ChronoUnit.MILLIS)
    @Fallback(DefaultMessage.class)
    String getProviderMessage();

    public static class DefaultMessage implements FallbackHandler<String> {

        @Override
        public String handle(ExecutionContext context) {
            return "Something went wrong but I provided a default";
        }

    }

}