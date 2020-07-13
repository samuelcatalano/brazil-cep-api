package org.acme.rest;

import lombok.extern.slf4j.Slf4j;
import org.acme.service.AddressService;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/ws")
@Slf4j
public class AddressRESTController {

    @Inject
    AddressService addressService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{cep}/json")
    public Response getAddressInfo(@PathParam(value = "cep") final String cep) throws Exception {
        try {
            var address = this.addressService.getAddressInfo(cep);
            return Response.ok(address).build();

        } catch (final Exception e) {
            log.error("Error getting address with this CEP!", e);
            throw new Exception(e.getMessage(), e);
        }
    }
}