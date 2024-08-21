package org.example.restro.controller;


import com.alibaba.fastjson.JSON;
import org.example.restro.RestroApplication;
import org.example.restro.model.Restaurant;
import org.example.restro.model.RestroAddress;
import org.example.restro.util.DishTestWrapper;
import org.example.restro.util.ItemTestWrapper;
import org.example.restro.util.ResroAddressWrapper;
import org.example.restro.util.RestaurantTestWrapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.ActiveProfiles;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.restro.util.request.RestaurantMockRequest.getRestaurant;
import static org.example.restro.util.request.RestaurantMockRequest.getRestroAddress;


@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = RestroApplication.class)
public class ControllerIT {

    private static final TestRestTemplate restTemplate = new TestRestTemplate();

    private String baseUrl;
    HttpHeaders headers;

    @Autowired
    private RestaurantTestWrapper restaurantTestWrapper;

    @Autowired
    private ResroAddressWrapper resroAddressWrapper;

    @Autowired
    private ItemTestWrapper itemTestWrapper;

    @Autowired
    private DishTestWrapper dishTestWrapper;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        baseUrl = "http://localhost:" + port + "/restro";
        headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
    }

    @AfterEach
    void tearDown() {
        System.out.println("after");
        dishTestWrapper.deletedAll();
        itemTestWrapper.deletedAll();
        resroAddressWrapper.deletedAll();
        restaurantTestWrapper.deletedAll();

    }

    @Test
    void testRestaurant() throws Exception {
        String url  = baseUrl + "/v1/api/restaurant/add";
        Restaurant restaurant = JSON.parseObject(getRestaurant, Restaurant.class);
        HttpEntity<Restaurant> requestEntity = new HttpEntity<>(restaurant, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.hasBody()).isTrue();
        Map<String, Object>  body = JSON.parseObject(response.getBody(), Map.class);
        assertThat(body)
                .isNotNull()
                .containsEntry("resultMessage", "Success")
                .containsEntry("resultCode", "1001")
                .containsEntry("success", true);
        Restaurant res = JSON.parseObject(JSON.toJSONString(body.get("data")), Restaurant.class);
        assertThat(res).isNotNull();
        assertThat(res.getId()).isNotNull();

        //testAddAddressAndRestaurant(res);
    }


    void testAddAddressAndRestaurant(Restaurant restaurant) {
        System.out.println("into testAddAddressAndRestaurant");
        String url  = baseUrl + "/v1/api/restaurant/address/add";
        RestroAddress req = JSON.parseObject(getRestroAddress, RestroAddress.class);
        req.setRestaurant(new Restaurant());
        req.getRestaurant().setId(restaurant.getId());
        HttpEntity<RestroAddress> requestEntity = new HttpEntity<>(req, headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.hasBody()).isTrue();
        Map<String, Object>  body = JSON.parseObject(response.getBody(), Map.class);
        assertThat(body)
                .isNotNull()
                .containsEntry("resultMessage", "Success")
                .containsEntry("resultCode", "1001")
                .containsEntry("success", true);
        RestroAddress res = JSON.parseObject(JSON.toJSONString(body.get("data")), RestroAddress.class);
        assertThat(res).isNotNull();
        assertThat(res.getId()).isNotNull();
    }

    @Test
    void testGetDish() {
        String url  = baseUrl + "/v1/api/restaurant/dish/get/1";
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, null, String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.hasBody()).isTrue();
        Map<String, Object>  body = JSON.parseObject(response.getBody(), Map.class);
        assertThat(body)
                .isNotNull()
                .containsEntry("resultMessage", "Success")
                .containsEntry("data", null)
                .containsEntry("success", true);
    }
}
