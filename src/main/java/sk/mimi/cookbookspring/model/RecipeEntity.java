package sk.mimi.cookbookspring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class RecipeEntity {
    @Id
    private Long id;

    @ManyToMany
    private Set<IngredienceEntity> ingrediences;

    private Time prepTime;

    private Time cookTime;

    private Time bakeTime;

    private Time overallTime;

    private Difficulty difficulty;

    @ManyToOne
    private UserEntity user;
}
