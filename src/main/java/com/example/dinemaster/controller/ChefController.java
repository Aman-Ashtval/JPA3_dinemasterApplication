package com.example.dinemaster.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

import com.example.dinemaster.service.ChefJpaService;
import com.example.dinemaster.model.*;

@RestController
public class ChefController {

    @Autowired
    private ChefJpaService chefJpaService;

    @GetMapping("restaurants/chefs")
    public ArrayList<Chef> getChefList() {
        return chefJpaService.getChefList();
    }

    @GetMapping("restaurants/chefs/{chefId}")
    public Chef getChefById(@PathVariable("chefId") int chefId) {
        return chefJpaService.getChefById(chefId);
    }

    @PostMapping("restaurants/chefs")
    public Chef adChef(@RequestBody Chef chef) {
        return chefJpaService.addChef(chef);
    }

    @PutMapping("/restaurants/chefs/{chefId}")
    public Chef updateChef(@PathVariable("chefId") int chefId, @RequestBody Chef chef) {
        return chefJpaService.updateChef(chefId, chef);
    }

    @DeleteMapping("restaurants/chefs/{chefId}")
    public void deleteChef(@PathVariable("chefId") int chefId) {
        chefJpaService.deleteChef(chefId);
    }

    @GetMapping("chefs/{chefId}/restaurant")
    public Restaurant getRestaurantByChef(@PathVariable("chefId") int chefId) {
        return chefJpaService.getRestaurentByChef(chefId);
    }
}