package org.example.restro.handler.impl;

import lombok.RequiredArgsConstructor;
import org.example.restro.handler.RestroAddressHandler;
import org.example.restro.model.RestroAddress;
import org.example.restro.service.RestroAddressService;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RestroAddressHandlerImpl implements RestroAddressHandler {

    public final RestroAddressService restroAddressService;

    @Override
    public RestroAddress addRestroAddress(RestroAddress restroAddress) {
        return restroAddressService.addRestroAddress(restroAddress);
    }

    @Override
    public RestroAddress getRestroAddress(Long id) {
        return restroAddressService.getRestroAddress(id);
    }

    @Override
    public RestroAddress updateRestroAddress(RestroAddress restroAddress) {
        return restroAddressService.updateRestroAddress(restroAddress);
    }

}
