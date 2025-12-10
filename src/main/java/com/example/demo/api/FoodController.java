package com.example.demo.api;

import com.example.demo.entity.Food;
import com.example.demo.service.foodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/v1/food")
@RestController
public class FoodController {
    private final foodService foodservice;

    @Autowired
    public FoodController(foodService foodservice)
    {
        this.foodservice= foodservice;
    }

    @PostMapping
    public void addFood(@RequestBody Food food)
    {
        foodservice.addFood(food);
    }

    @GetMapping
   public List<Food>getAllFood()
   {
       return foodservice.getFoodDetails();
   }

   @GetMapping(path="{name}")
   public Food getPersonByName(@PathVariable("name") String name)
   {
       return foodservice.getFoodByName(name)
               .orElse(null);
   }

   @PutMapping(path = "{name}")
   public void updateFood(@PathVariable("name") String name,@RequestBody Food food)
   {
       foodservice.updateFood(name, food);
   }

   @DeleteMapping(path="{name}")
   public void deleteFood(@PathVariable("name") String name)
   {
       foodservice.deleteFood(name);
   }
}
