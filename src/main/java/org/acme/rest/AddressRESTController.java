package org.acme.rest;

import lombok.extern.slf4j.Slf4j;
import org.acme.service.BrazilAddressService;
import org.acme.service.LondonAddressService;

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
    BrazilAddressService brazilAddressService;

    @Inject
    LondonAddressService londonAddressService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{cep}/json")
    public Response getBrazilAddressInfo(@PathParam(value = "cep") final String cep) throws Exception {
        try {
            var address = this.brazilAddressService.getAddressInfo(cep);
            return Response.ok(address).build();

        } catch (final Exception e) {
            log.error("Error getting address with this CEP!", e);
            throw new Exception(e.getMessage(), e);
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{postcode}")
    public Response getLondonAddressInfo(@PathParam(value = "postcode") final String postcode) throws Exception {
        try {
            var address = this.londonAddressService.getAddressInfo(postcode);
            return Response.ok(address).build();

        } catch (final Exception e) {
            log.error("Error getting address with this postcode!", e);
            throw new Exception(e.getMessage(), e);
        }
    }
}