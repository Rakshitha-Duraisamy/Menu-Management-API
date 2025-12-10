package com.example.demo.repository;

import com.example.demo.entity.Food;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Random;


public interface FoodDao {

    int insertFood(long id,Food food);

    default int insertFood(Food food)
    {
        Random random=new Random();
        long id= random.nextLong();
        return insertFood(id,food);
    }
    public List<Food> showFoodDetails();

    Optional<Food> selectFoodByName(String name);

    int deleteFoodByName(String name);

    int updateFoodByName(String name,Food food);
}
