package sk.mimi.cookbookspring.DTO.mapper;

import sk.mimi.cookbookspring.DTO.RecipeEntity;
import sk.mimi.cookbookspring.model.Recipe;

public class RecipeMapper {

    public static RecipeEntity toEntity(Recipe recipe){
        return RecipeEntity.builder()
                .id(recipe.getId())
                .bakeTime(recipe.getBakeTime())
                .cookTime(recipe.getCookTime())
                .overallTime(recipe.getOverallTime())
                .difficulty(recipe.getDifficulty())
                .ingrediences(recipe.getIngrediences())
                .prepTime(recipe.getPrepTime())
                .user(recipe.getUser())
                .build();
    }

    public static Recipe fromEntity(RecipeEntity recipeEntity){
        return Recipe.builder()
                .id(recipeEntity.getId())
                .bakeTime(recipeEntity.getBakeTime())
                .cookTime(recipeEntity.getCookTime())
                .overallTime(recipeEntity.getOverallTime())
                .difficulty(recipeEntity.getDifficulty())
                .ingrediences(recipeEntity.getIngrediences())
                .prepTime(recipeEntity.getPrepTime())
                .user(recipeEntity.getUser())
                .build();
    }
}
