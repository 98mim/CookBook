package sk.mimi.cookbookspring.DTO.model.addRecipe;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import sk.mimi.cookbookspring.model.CourseType;
import sk.mimi.cookbookspring.model.Difficulty;

import java.util.Set;

@NoArgsConstructor
@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddRecipeRequest {
    private String name;

    private String image;

    private Set<AddIngredientRequest> ingredients;

    private Set<AddMethodRequest> methods;

    private int prepTime;

    private int cookTime;

    private int bakeTime;

    private int overallTime;

    private Difficulty difficulty;

    private CourseType courseType;

}
