package sk.mimi.cookbookspring.service;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.mimi.cookbookspring.DTO.mapper.FoodMapper;
import sk.mimi.cookbookspring.DTO.model.Food;
import sk.mimi.cookbookspring.DTO.model.response.IngredientResponse;
import sk.mimi.cookbookspring.model.FoodEntity;
import sk.mimi.cookbookspring.repository.FoodRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ingredient")
@ControllerAdvice
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor
public class FoodService {
   private final FoodRepository foodRepository;
   private final FoodMapper foodMapper;

   public Set<Food> getAllFoods(){
       List<FoodEntity> foods = foodRepository.findAll();
       return foods.stream().map(foodEntity -> foodMapper.fromEntity(foodEntity)).collect(Collectors.toSet());
   }
}
