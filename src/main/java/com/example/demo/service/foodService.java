package com.example.demo.service;

import com.example.demo.entity.Food;
import com.example.demo.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class foodService {

    private final FoodRepository foodRepository;

    @Autowired
    public foodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public Food addFood(Food food) {
        return foodRepository.save(food);
    }

    public List<Food> getFoodDetails() {
        return foodRepository.findAll();
    }

    public Optional<Food> getFoodByName(String name) {
        return Optional.ofNullable(foodRepository.findByName(name));
    }

    public void deleteFood(String name) {
        Food food = foodRepository.findByName(name);
        if (food != null) {
            foodRepository.delete(food);
        }
    }

    public void updateFood(String name, Food newFood) {
        Food existing = foodRepository.findByName(name);
        if (existing != null) {
            existing.setCategory(newFood.getCategory());
            existing.setName(newFood.getName());
            existing.setPrice(newFood.getPrice());
            existing.setAvailability(newFood.isAvailability());
            foodRepository.save(existing);
        }
    }
}
