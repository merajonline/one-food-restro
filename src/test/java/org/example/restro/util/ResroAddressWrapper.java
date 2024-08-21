package org.example.restro.util;

import lombok.RequiredArgsConstructor;
import org.example.restro.repository.RestroAddressRepository;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ResroAddressWrapper {

    private final RestroAddressRepository restroAddressRepository;

    public void deletedAll() {
        restroAddressRepository.deleteAll();
    }
}
