package org.example.restro.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.restro.handler.RestroAddressHandler;
import org.example.restro.model.RestroAddress;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "v1/api/restaurant/address")
public class RestroAddressController {

    public final RestroAddressHandler restroAddressHandler;


    @PostMapping(value = "/add")
    public ResponseEntity<RestroAddress> addRestroAddress(@Validated @RequestBody RestroAddress restroAddress) {
        log.info("into addRestaurant");
        return new ResponseEntity<>(restroAddressHandler.addRestroAddress(restroAddress), HttpStatus.OK);
    }

    @GetMapping(value = "/get/{id}")
    public ResponseEntity<RestroAddress> getRestroAddress(@Validated @PathVariable(value = "id") Long id) {
        log.info("into getRestroAddress");
        return new ResponseEntity<>(restroAddressHandler.getRestroAddress(id), HttpStatus.OK);
    }

    @GetMapping(value = "/restroId/{id}")
    public ResponseEntity<RestroAddress> getRestroAddressByRestroId(@Validated @PathVariable(value = "id") Long id) {
        log.info("into getRestroAddressByRestroId");
        return new ResponseEntity<>(restroAddressHandler.getRestroAddress(id), HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<RestroAddress> updateAddressByRestroId(@Validated @RequestBody RestroAddress restroAddress) {
        log.info("into getRestaurant");
        return new ResponseEntity<>(restroAddressHandler.updateRestroAddress(restroAddress), HttpStatus.OK);
    }
}
