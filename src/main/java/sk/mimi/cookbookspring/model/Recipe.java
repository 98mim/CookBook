package sk.mimi.cookbookspring.model;

import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sk.mimi.cookbookspring.DTO.IngredienceEntity;
import sk.mimi.cookbookspring.DTO.UserEntity;

import java.sql.Time;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
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
