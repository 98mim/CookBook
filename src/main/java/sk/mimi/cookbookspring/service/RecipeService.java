package sk.mimi.cookbookspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import sk.mimi.cookbookspring.DTO.filter.RecipeFilter;
import sk.mimi.cookbookspring.DTO.mapper.RecipeMapper;
import sk.mimi.cookbookspring.DTO.model.Recipe;
import sk.mimi.cookbookspring.model.RecipeEntity;
import sk.mimi.cookbookspring.repository.RecipeRepository;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private RecipeMapper recipeMapper;

    public Recipe addRecipe(Recipe recipe) {
        return recipeMapper.fromEntity(
                recipeRepository.save(
                        recipeMapper.toEntity(recipe)
                ));
    }

    public Page<Recipe> filterRecipes(RecipeFilter recipeFilter, Pageable pageable) {
        Specification<RecipeEntity> specification = recipeFilter.buildSpecification();
        Page<RecipeEntity> recipeEntities = recipeRepository.findAll(specification, pageable);
        return recipeEntities.map(recipeEntity -> recipeMapper.fromEntity(recipeEntity));
    }

    public Page<Recipe> allRecipes(Pageable pageable) {
        Page<RecipeEntity> recipeEntities = recipeRepository.findAll(pageable);
        return recipeEntities.map(recipeEntity -> recipeMapper.fromEntity(recipeEntity));
    }
}
