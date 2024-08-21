package org.example.restro.handler;

import org.example.restro.model.RestroAddress;

public interface RestroAddressHandler {

    RestroAddress addRestroAddress(RestroAddress restroAddress);
    RestroAddress getRestroAddress(Long id);
    RestroAddress updateRestroAddress(RestroAddress restroAddress);

}
