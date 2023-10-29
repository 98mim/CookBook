package sk.mimi.cookbookspring.DTO.mapper;

import org.mapstruct.Mapper;
import sk.mimi.cookbookspring.DTO.model.Ingredient;
import sk.mimi.cookbookspring.model.IngredientEntity;

@Mapper
public interface IngredientMapper {


    IngredientEntity toEntity(Ingredient ingredient);

    Ingredient fromEntity(IngredientEntity ingredientEntity);
}
