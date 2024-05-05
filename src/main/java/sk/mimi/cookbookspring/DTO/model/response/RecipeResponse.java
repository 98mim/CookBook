package sk.mimi.cookbookspring.DTO.model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sk.mimi.cookbookspring.DTO.model.Ingredient;
import sk.mimi.cookbookspring.DTO.model.User;
import sk.mimi.cookbookspring.model.CourseType;
import sk.mimi.cookbookspring.model.Difficulty;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecipeResponse {
    private Long id;

    private String name;

    private String imagePath;

    private Set<IngredientResponse> ingredients;

    private Set<MethodResponse> methods;

    private int prepTime;

    private int cookTime;

    private int bakeTime;

    private int overallTime;

    private Difficulty difficulty;

    private UserResponse user;

    private CourseType courseType;
}
