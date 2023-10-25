package sk.mimi.cookbookspring.controller;


import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import sk.mimi.cookbookspring.DTO.filter.RecipeFilter;
import sk.mimi.cookbookspring.DTO.model.Recipe;
import sk.mimi.cookbookspring.exception.BadRequestException;
import sk.mimi.cookbookspring.service.RecipeService;

@RestController
@RequestMapping("/book")
@ControllerAdvice
public class BookController {

    @Autowired
    private RecipeService recipeService;

    @PutMapping("/add")
    public Recipe insertRecipe(@RequestBody Recipe recipe){
        if (!recipe.isRecipeValid(recipe)) {
            throw new BadRequestException("Custom error message");
        }
        return recipeService.addRecipe(recipe);
    }
    @Operation(summary = "Get a book by its id")
    @PostMapping("/filter")
    public Page<Recipe> filterRecipes(@RequestBody RecipeFilter recipeFilter,
                                      @RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "10") int size,
                                      @RequestParam(defaultValue = "name") String sortField,
                                      @RequestParam(defaultValue = "ASC") Sort.Direction sortDirection){
        return recipeService.filterRecipes(recipeFilter, createPageable(page, size, sortField, sortDirection));
    }

    @GetMapping("/all")
    public Page<Recipe> filterRecipes(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "10") int size,
                                      @RequestParam(defaultValue = "name") String sortField,
                                      @RequestParam(defaultValue = "ASC") Sort.Direction sortDirection){
        return recipeService.allRecipes(createPageable(page, size, sortField, sortDirection));
    }

    public Pageable createPageable(int page, int size, String sortField, Sort.Direction sortDirection) {
        Sort sort = Sort.by(sortDirection, sortField);
        Pageable pageable = PageRequest.of(page, size, sort);
        return pageable;
    }
}
