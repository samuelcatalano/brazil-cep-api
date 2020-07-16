package org.acme.service;

import lombok.extern.slf4j.Slf4j;
import org.acme.client.LondonAddressClient;
import org.acme.model.LondonInfo;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Slf4j
@ApplicationScoped
public class LondonAddressService {

    @Inject
    @RestClient
    LondonAddressClient londonAddressClient;

    /**
     * Returns the address by postal code.
     * @param postcode the postal code
     * @return the address by postal code
     * @throws Exception
     */
    public LondonInfo getAddressInfo(final String postcode) throws Exception {
        var address = this.londonAddressClient.getAddressInfo(postcode);
        if (address == null) {
            log.error("Error getting address with this postcode {}: ", postcode);
            throw new Exception("There is no address with this postcode!");
        }

        log.info("Returning valid address");
        return address;
    }
}
