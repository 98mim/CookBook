package sk.mimi.cookbookspring.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.mimi.cookbookspring.DTO.model.addRecipe.AddRecipeRequest;
import sk.mimi.cookbookspring.DTO.model.response.RecipeResponse;
import sk.mimi.cookbookspring.service.RecipeService;

import java.security.Principal;
import java.util.Base64;

@RestController
@RequestMapping("/recipe")
@ControllerAdvice
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @PostMapping("/add")
    public RecipeResponse insertRecipe(@RequestBody AddRecipeRequest recipe, Principal connectedUser) {
        /*if (!recipe.isRecipeValid(recipe)) {
            throw new BadRequestException("Custom error message");
        }*/
        return recipeService.addRecipe(recipe, connectedUser.getName());
    }

    @GetMapping("/detail/{id}")
    public RecipeResponse getRecipe(@PathVariable Long id){
        return recipeService.getRecipe(id);
    }

    @PostMapping("/update/{id}")
    public RecipeResponse updateRecipe(@RequestBody RecipeResponse recipeResponse, Principal connectedUser){
        return recipeService.updateRecipe(recipeResponse, connectedUser.getName());
    }

}
