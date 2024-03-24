package com.example.dinemaster.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.ArrayList;
import java.util.List;

import com.example.dinemaster.model.*;
import com.example.dinemaster.repository.*;

@Service
public class ChefJpaService implements ChefRepository {

    @Autowired
    private ChefJpaRepository chefJpaRepository;

    @Autowired
    private RestaurantJpaRepository restaurantJpaRepository;

    @Override
    public ArrayList<Chef> getChefList() {
        List<Chef> chefList = chefJpaRepository.findAll();
        return new ArrayList(chefList);
    }

    @Override
    public Chef getChefById(int chefId) {
        try {
            Chef chef = chefJpaRepository.findById(chefId).get();
            return chef;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Chef addChef(Chef chef) {
        Restaurant restaurant = chef.getRestaurant();
        int id = restaurant.getId();
        try {
            Restaurant newRestaurant = restaurantJpaRepository.findById(id).get();
            chef.setRestaurant(newRestaurant);
            chefJpaRepository.save(chef);
            return chef;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Chef updateChef(int chefId, Chef chef) {
        try {
            Chef oldChef = chefJpaRepository.findById(chefId).get();
            if (chef.getFirstName() != null)
                oldChef.setFirstName(chef.getFirstName());
            if (chef.getLastName() != null)
                oldChef.setLastName(chef.getLastName());
            if (chef.getExpertise() != null)
                oldChef.setExpertise(chef.getExpertise());
            if (chef.getExperienceYears() >= 0)
                oldChef.setExperienceYears(chef.getExperienceYears());
            if (chef.getRestaurant() != null) {
                Restaurant restaurant = chef.getRestaurant();
                int restaurantId = restaurant.getId();
                Restaurant newRestaurant = restaurantJpaRepository.findById(restaurantId).get();
                oldChef.setRestaurant(newRestaurant);
            }
            chefJpaRepository.save(oldChef);
            return oldChef;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteChef(int chefId) {
        Chef chef = this.getChefById(chefId);

        if (chef != null) {
            chefJpaRepository.deleteById(chefId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }

    @Override
    public Restaurant getRestaurentByChef(int chefId) {
        try {
            Chef chef = chefJpaRepository.findById(chefId).get();
            return chef.getRestaurant();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}