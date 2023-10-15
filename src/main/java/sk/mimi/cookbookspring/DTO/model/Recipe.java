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
    private Set<IngredienceEntity> ingrediences;

    private Time prepTime;

    private Time cookTime;

    private Time bakeTime;

    private Time overallTime;

    private Difficulty difficulty;

    @ManyToOne
    private UserEntity user;
}
