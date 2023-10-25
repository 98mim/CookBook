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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    private Set<IngredienceEntity> ingrediences;

    private int prepTime;

    private int cookTime;

    private int bakeTime;

    private int overallTime;

    private Difficulty difficulty;

    @ManyToOne
    private UserEntity user;
}
