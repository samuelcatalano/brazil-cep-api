package org.acme.client;

import org.acme.model.LondonInfo;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/postcodes")
@RegisterRestClient
public interface LondonAddressClient {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{postcode}")
    LondonInfo getAddressInfo(@PathParam(value = "postcode") final String postcode);
}
