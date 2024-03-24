package com.example.dinemaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

import com.example.dinemaster.service.RestaurantJpaService;
import com.example.dinemaster.model.Restaurant;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantJpaService restaurantJpaService;

    @GetMapping("/restaurants")
    public ArrayList<Restaurant> getRestaurants() {
        return restaurantJpaService.getRestaurents();
    }

    @PostMapping("restaurants")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantJpaService.addRestaurant(restaurant);
    }

    @GetMapping("restaurants/{restaurantId}")
    public Restaurant getRestaurantById(@PathVariable("restaurantId") int restaurantId) {
        return restaurantJpaService.getRestaurantById(restaurantId);
    }

    @PutMapping("restaurants/{restaurantId}")
    public Restaurant updateRestaurant(@PathVariable("restaurantId") int restaurantId,
            @RequestBody Restaurant restaurant) {
        return restaurantJpaService.updateRestaurant(restaurantId, restaurant);
    }

    @DeleteMapping("restaurants/{restaurantId}")
    public void deleteRestaurantById(@PathVariable("restaurantId") int restaurantId) {
        restaurantJpaService.deleteRestaurantById(restaurantId);
    }
}