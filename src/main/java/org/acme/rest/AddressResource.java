package org.acme.rest;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/ws")
public class AddressResource {

    @Inject
    @RestClient
    AddressService addressService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{cep}/json")
    public Response getName(@PathParam(value = "cep") final String cep) {
        var address = this.addressService.getAddressInfo(cep);
        return Response.ok(address).build();
    }
}
