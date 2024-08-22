package org.example.restro.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.restro.exception.BixException;
import org.example.restro.model.RestroAddress;
import org.example.restro.repository.RestroAddressRepository;
import org.example.restro.service.RestroAddressService;
import org.example.restro.util.CustomBeanUtils;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static org.example.restro.exception.CommonApiResultCode.INVALID_RESRTO_ADDRESS;
import static org.example.restro.exception.CommonApiResultCode.INVALID_RESRTO_ADDRESS_ID;

@Service
@RequiredArgsConstructor
public class RestroAddressServiceImpl implements RestroAddressService {

    private final RestroAddressRepository restroAddressRepository;

    @Override
    public RestroAddress addRestroAddress(RestroAddress restroAddress) {
        if (Objects.isNull(restroAddress)) {
            throw new BixException(INVALID_RESRTO_ADDRESS);
        }
        long currentTime = System.currentTimeMillis();
        restroAddress.setCreatedDate(currentTime);
        restroAddress.setUpdatedDate(currentTime);
        if (Objects.nonNull(restroAddress.getRestaurant()) && Objects.isNull(restroAddress.getRestaurant().getId())) {
            restroAddress.getRestaurant().setCreatedDate(currentTime);
            restroAddress.getRestaurant().setUpdatedDate(currentTime);
        }
        return restroAddressRepository.save(restroAddress);
    }

    @Override
    public RestroAddress getRestroAddress(Long id) {
        return restroAddressRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public RestroAddress updateRestroAddress(RestroAddress restroAddress) {
        RestroAddress restroAddressFromDb =  restroAddressRepository.findById(restroAddress.getId()).orElse(null);
        if (Objects.nonNull(restroAddressFromDb)) {
            CustomBeanUtils.copyNonNullProperties(restroAddress, restroAddressFromDb);
        } else {
            throw BixException.of(INVALID_RESRTO_ADDRESS_ID);
        }
        return restroAddressRepository.saveAndFlush(restroAddressFromDb);
    }

}
