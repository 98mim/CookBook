package sk.mimi.cookbookspring.DTO.mapper;

import org.mapstruct.Mapper;
import sk.mimi.cookbookspring.DTO.model.addRecipe.AddRecipeRequest;
import sk.mimi.cookbookspring.DTO.model.page.BriefRecipeResponse;
import sk.mimi.cookbookspring.DTO.model.response.RecipeResponse;
import sk.mimi.cookbookspring.model.RecipeEntity;
import sk.mimi.cookbookspring.DTO.model.Recipe;

@Mapper(componentModel = "spring")
public interface RecipeMapper {

    RecipeEntity toEntity(Recipe recipe);

    Recipe fromEntity(RecipeEntity recipeEntity);

    RecipeEntity RequestToEntity(AddRecipeRequest recipe);

    RecipeResponse toRecipeResponse(RecipeEntity recipeEntity);

    BriefRecipeResponse toBriefRecipeResponse(RecipeEntity recipeEntity);
}
