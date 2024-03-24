package com.example.dinemaster.repository;

import java.util.ArrayList;
import com.example.dinemaster.model.Restaurant;

public interface RestaurantRepository {
    ArrayList<Restaurant> getRestaurents();

    Restaurant addRestaurant(Restaurant restaurant);

    Restaurant getRestaurantById(int restaurantId);

    Restaurant updateRestaurant(int restaurantId, Restaurant restaurant);

    void deleteRestaurantById(int restaurantId);
}