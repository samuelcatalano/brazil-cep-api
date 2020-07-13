package org.acme.service;

import lombok.extern.slf4j.Slf4j;
import org.acme.model.Address;
import org.acme.client.AddressClient;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Slf4j
@ApplicationScoped
public class AddressService {

    @Inject
    @RestClient
    AddressClient addressClient;

    /**
     * Returns the address by CEP.
     * @param cep
     * @return the address by CEP
     * @throws Exception
     */
    public Address getAddressInfo(final String cep) throws Exception {
        var address = this.addressClient.getAddressInfo(cep);
        if (address == null) {
            log.error("Error getting address with this CEP {}: ", cep);
            throw new Exception("There is no address with this CEP!");
        }

        log.info("Returning valid address");
        return address;
    }
}
