package com.example.dinemaster.repository;

import java.util.ArrayList;
import com.example.dinemaster.model.*;

public interface ChefRepository {

    ArrayList<Chef> getChefList();

    Chef getChefById(int chefId);

    Chef addChef(Chef chef);

    Chef updateChef(int chefId, Chef chef);

    void deleteChef(int chefId);

    Restaurant getRestaurentByChef(int chefId);

}