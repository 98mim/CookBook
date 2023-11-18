package sk.mimi.cookbookspring.DTO.model.addRecipe;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sk.mimi.cookbookspring.DTO.model.Food;
import sk.mimi.cookbookspring.model.WeightUnit;

@NoArgsConstructor
@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddIngredientRequest {
    private int weight;

    private WeightUnit weightUnit;

    private AddFoodRequest food;
}
