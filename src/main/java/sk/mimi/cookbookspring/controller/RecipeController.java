package sk.mimi.cookbookspring.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.mimi.cookbookspring.DTO.model.Recipe;
import sk.mimi.cookbookspring.DTO.model.addRecipe.AddRecipeRequest;
import sk.mimi.cookbookspring.DTO.model.response.RecipeResponse;
import sk.mimi.cookbookspring.exception.BadRequestException;
import sk.mimi.cookbookspring.service.RecipeService;

import java.security.Principal;

@RestController
@RequestMapping("/recipe")
@ControllerAdvice
@SecurityRequirement(name = "Bearer Authentication")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @PostMapping("/add")
    public RecipeResponse insertRecipe(@RequestBody AddRecipeRequest recipe, Principal connectedUser) {
        /*if (!recipe.isRecipeValid(recipe)) {
            throw new BadRequestException("Custom error message");
        }*/
        return recipeService.addRecipe(recipe, connectedUser.getName());
    }
}
