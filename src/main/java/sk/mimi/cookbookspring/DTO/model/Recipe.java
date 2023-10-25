package sk.mimi.cookbookspring.DTO.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sk.mimi.cookbookspring.model.IngredienceEntity;
import sk.mimi.cookbookspring.model.UserEntity;
import sk.mimi.cookbookspring.model.Difficulty;

import java.sql.Time;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Recipe {

    private Long id;

    private String name;

    private Set<Ingredience> ingrediences;

    private int prepTime;

    private int cookTime;

    private int bakeTime;

    private int overallTime;

    private Difficulty difficulty;

    @ManyToOne
    private User user;

    public boolean isRecipeValid(Recipe recipe) {
        // Implement your validation logic here.
        // Check if the recipe meets your business rules.
        // Return true if valid; otherwise, return false.
        return true;
    }
}
