package com.example.demo.repository;

import com.example.demo.entity.Food;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("fakeDao")
public class fakeFooddetails implements FoodDao{

    private static List<Food>DB=new ArrayList<>();

    @Override
    public int insertFood(long id, Food food) {
        DB.add(new Food(id,food.getName(),food.getPrice(), food.getCategory(), food.isAvailability()));
        return 0;
    }

    @Override
    public List<Food> showFoodDetails() {
        return DB;
    }

    @Override
    public Optional<Food> selectFoodByName(String name) {
        return DB.stream().
                filter(food -> food.getName().equals(name))
                .findFirst();
    }

    @Override
    public int deleteFoodByName(String name) {
        Optional<Food>foodTodelete=selectFoodByName(name);
        if(foodTodelete.isEmpty())
            return 0;
        DB.remove(foodTodelete.get());
        return 1;
    }

    @Override
    public int updateFoodByName(String name, Food food) {
        return selectFoodByName(name)
                .map(food1 ->{
                    int indexOfFoodToUpdate=DB.indexOf(food1);
                    if(indexOfFoodToUpdate>=0) {
                        DB.set(indexOfFoodToUpdate, new Food(food.getId(), name, food.getPrice(), food.getCategory(), food.isAvailability()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);

    }
}
