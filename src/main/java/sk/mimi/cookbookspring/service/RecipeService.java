package sk.mimi.cookbookspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sk.mimi.cookbookspring.DTO.model.Recipe;
import sk.mimi.cookbookspring.repository.RecipeRepository;

@Repository
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public void addReceipt(Recipe recipe){

    }
}
