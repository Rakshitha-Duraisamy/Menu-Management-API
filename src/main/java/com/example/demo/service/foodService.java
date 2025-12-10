package com.example.demo.service;

import com.example.demo.entity.Food;
import com.example.demo.repository.FoodDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class foodService {

    private final FoodDao foodDao;

    @Autowired
    public foodService(@Qualifier("fakeDao") FoodDao foodDao)
    {
        this.foodDao=foodDao;
    }
    public int addFood(Food food){
        return foodDao.insertFood(food);
    }

    public List<Food> getFoodDetails()
    {
        return foodDao.showFoodDetails();
    }

    public Optional<Food> getFoodByName(String name)
    {
        return foodDao.selectFoodByName(name);
    }

    public int deleteFood(String name)
    {
        return foodDao.deleteFoodByName(name);
    }

    public int updateFood(String name,Food food)
    {
        return foodDao.updateFoodByName(name,food);
    }
}
