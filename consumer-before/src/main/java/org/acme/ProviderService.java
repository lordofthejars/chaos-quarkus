package org.acme;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/hello")
@RegisterRestClient
public interface ProviderService {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    String getProviderMessage();
    
}