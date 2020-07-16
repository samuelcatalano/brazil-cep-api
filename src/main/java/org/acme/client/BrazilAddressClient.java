package org.acme.client;

import org.acme.model.BrazilAddress;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/ws")
@RegisterRestClient
public interface BrazilAddressClient {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{cep}/json")
    BrazilAddress getAddressInfo(@PathParam(value = "cep") final String cep);
}