package sk.mimi.cookbookspring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import sk.mimi.cookbookspring.DTO.filter.RecipeFilter;
import sk.mimi.cookbookspring.DTO.mapper.RecipeMapper;
import sk.mimi.cookbookspring.DTO.model.Recipe;
import sk.mimi.cookbookspring.DTO.model.addRecipe.AddRecipeRequest;
import sk.mimi.cookbookspring.DTO.model.page.BriefRecipeResponse;
import sk.mimi.cookbookspring.DTO.model.response.RecipeResponse;
import sk.mimi.cookbookspring.exception.BadRequestException;
import sk.mimi.cookbookspring.model.IngredientEntity;
import sk.mimi.cookbookspring.model.MethodEntity;
import sk.mimi.cookbookspring.model.RecipeEntity;
import sk.mimi.cookbookspring.model.UserEntity;
import sk.mimi.cookbookspring.repository.IngredientRepository;
import sk.mimi.cookbookspring.repository.MethodRepository;
import sk.mimi.cookbookspring.repository.RecipeRepository;
import sk.mimi.cookbookspring.repository.UserRepository;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;
    private final UserRepository userRepository;
    private final RecipeMapper recipeMapper;
    private final MethodRepository methodRepository;

    private String imageDir = "src/main/resources/static/recipes/";

    public RecipeResponse addRecipe(AddRecipeRequest recipe, String username) {
        RecipeEntity recipeEntity = recipeMapper.RequestToEntity(recipe);

        byte[] decodedImage = Base64.getDecoder().decode(recipe.getImage().getBytes(StandardCharsets.UTF_8));

        String timestamp = String.valueOf(System.currentTimeMillis());
        String imageName = recipe.getName().replaceAll("\\s+", "_") + "_" + timestamp + ".png";

        recipeEntity.setImagePath(imageName);
        try {
            Files.write(Paths.get(imageDir + imageName), decodedImage);
        } catch (IOException e) {
            throw new RuntimeException("Failed to save the image.", e);
        }


        UserEntity user = userRepository.findByEmail(username).orElseThrow();
        recipeEntity.setUser(user);
        Set<IngredientEntity> ingredients = recipeEntity.getIngredients();
        Set<MethodEntity> methods = recipeEntity.getMethods();

        recipeEntity.setIngredients(null);
        recipeEntity.setMethods(null);
        recipeRepository.save(recipeEntity);

        ingredients.forEach(ingredient -> ingredient.setRecipe(recipeEntity));
        ingredientRepository.saveAll(ingredients);

        methods.forEach(method -> method.setRecipe(recipeEntity));
        methodRepository.saveAll(methods);

        recipeEntity.setIngredients(ingredients);
        recipeEntity.setMethods(methods);
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

    public RecipeResponse getRecipe(Long id){
        return recipeMapper.toRecipeResponse(recipeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException()));
    }
}
