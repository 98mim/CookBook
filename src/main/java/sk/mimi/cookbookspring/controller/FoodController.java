package sk.mimi.cookbookspring.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.mimi.cookbookspring.DTO.model.Food;
import sk.mimi.cookbookspring.service.FoodService;

import java.util.Set;

@RestController
@RequestMapping("/food")
@ControllerAdvice
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor
public class FoodController {

    private final FoodService foodService;

    @GetMapping("/all")
    public Set<Food> getFoods(){
        return foodService.getAllFoods();
    }
}
