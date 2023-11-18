package sk.mimi.cookbookspring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import sk.mimi.cookbookspring.DTO.filter.RecipeFilter;
import sk.mimi.cookbookspring.DTO.mapper.RecipeMapper;
import sk.mimi.cookbookspring.DTO.model.Recipe;
import sk.mimi.cookbookspring.DTO.model.addRecipe.AddRecipeRequest;
import sk.mimi.cookbookspring.DTO.model.page.BriefRecipeResponse;
import sk.mimi.cookbookspring.DTO.model.response.RecipeResponse;
import sk.mimi.cookbookspring.exception.BadRequestException;
import sk.mimi.cookbookspring.model.IngredientEntity;
import sk.mimi.cookbookspring.model.RecipeEntity;
import sk.mimi.cookbookspring.model.UserEntity;
import sk.mimi.cookbookspring.repository.IngredientRepository;
import sk.mimi.cookbookspring.repository.RecipeRepository;
import sk.mimi.cookbookspring.repository.UserRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RecipeMapper recipeMapper;

    public RecipeResponse addRecipe(AddRecipeRequest recipe, String username) {
        RecipeEntity recipeEntity = recipeMapper.RequestToEntity(recipe);
        UserEntity user = userRepository.findByEmail(username).orElseThrow();
        recipeEntity.setUser(user);
        Set<IngredientEntity> ingredients = recipeEntity.getIngredients();

        recipeEntity.setIngredients(null);
        recipeRepository.save(recipeEntity);

        ingredients.forEach(ingredient -> ingredient.setRecipe(recipeEntity));
        ingredientRepository.saveAll(ingredients);

        recipeEntity.setIngredients(ingredients);
        return recipeMapper.toRecipeResponse(recipeEntity);
    }

    public Page<BriefRecipeResponse> filterRecipes(RecipeFilter recipeFilter, Pageable pageable) {
        Specification<RecipeEntity> specification = recipeFilter.buildSpecification();
        Page<RecipeEntity> recipeEntities = recipeRepository.findAll(specification, pageable);
        return recipeEntities.map(recipeEntity -> recipeMapper.toBriefRecipeResponse(recipeEntity));
    }

    public Page<BriefRecipeResponse> allRecipes(Pageable pageable) {
        Page<RecipeEntity> recipeEntities = recipeRepository.findAll(pageable);
        return recipeEntities.map(recipeEntity -> recipeMapper.toBriefRecipeResponse(recipeEntity));
    }
}
