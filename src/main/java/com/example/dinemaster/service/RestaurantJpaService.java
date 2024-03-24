package com.example.dinemaster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;

import com.example.dinemaster.model.Restaurant;
import com.example.dinemaster.repository.RestaurantJpaRepository;
import com.example.dinemaster.repository.RestaurantRepository;

@Service
public class RestaurantJpaService implements RestaurantRepository {

    @Autowired
    private RestaurantJpaRepository restaurantJpaRepository;

    @Override
    public ArrayList<Restaurant> getRestaurents() {
        List<Restaurant> restaurantList = restaurantJpaRepository.findAll();
        return new ArrayList(restaurantList);
    }

    @Override
    public Restaurant addRestaurant(Restaurant restaurant) {
        restaurantJpaRepository.save(restaurant);
        return restaurant;
    }

    @Override
    public Restaurant getRestaurantById(int restaurantId) {
        try {
            Restaurant restaurant = restaurantJpaRepository.findById(restaurantId).get();
            return restaurant;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Restaurant updateRestaurant(int restaurantId, Restaurant restaurant) {
        try {
            Restaurant oldRestaurant = restaurantJpaRepository.findById(restaurantId).get();
            if (restaurant.getName() != null)
                oldRestaurant.setName(restaurant.getName());
            if (restaurant.getAddress() != null)
                oldRestaurant.setAddress(restaurant.getAddress());
            if (restaurant.getCuisineType() != null)
                oldRestaurant.setCuisineType(restaurant.getCuisineType());
            if (restaurant.getRating() > 0)
                oldRestaurant.setRating(restaurant.getRating());
            restaurantJpaRepository.save(oldRestaurant);
            return oldRestaurant;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteRestaurantById(int restaurantId) {
        Restaurant restaurant = this.getRestaurantById(restaurantId);
        if (restaurant != null) {
            restaurantJpaRepository.deleteById(restaurantId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }

}