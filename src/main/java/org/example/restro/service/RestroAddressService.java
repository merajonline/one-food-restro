package org.example.restro.service;

import org.example.restro.model.RestroAddress;

public interface RestroAddressService {

    RestroAddress addRestroAddress(RestroAddress restroAddress);
    RestroAddress getRestroAddress(Long id);
    RestroAddress updateRestroAddress(RestroAddress restroAddress);

}
