package sk.mimi.cookbookspring.DTO.mapper;

import org.mapstruct.Mapper;
import sk.mimi.cookbookspring.model.RecipeEntity;
import sk.mimi.cookbookspring.DTO.model.Recipe;

@Mapper
public interface RecipeMapper {

    RecipeEntity toEntity(Recipe recipe);

    Recipe fromEntity(RecipeEntity recipeEntity);
}
