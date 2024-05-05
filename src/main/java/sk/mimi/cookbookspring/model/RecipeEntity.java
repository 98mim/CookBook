package sk.mimi.cookbookspring.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Recipe")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode
public class RecipeEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String imagePath;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "recipe", fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private Set<IngredientEntity> ingredients;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "recipe", fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private Set<MethodEntity> methods;

    private int prepTime;

    private int cookTime;

    private int bakeTime;

    private int overallTime;

    private Difficulty difficulty;

    private CourseType courseType;

    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
