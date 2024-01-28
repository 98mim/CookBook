package sk.mimi.cookbookspring.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

import static jakarta.persistence.FetchType.EAGER;

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

    @Column(columnDefinition = "TEXT")
    private String method;

    private int prepTime;

    private int cookTime;

    private int bakeTime;

    private int overallTime;

    private Difficulty difficulty;

    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
