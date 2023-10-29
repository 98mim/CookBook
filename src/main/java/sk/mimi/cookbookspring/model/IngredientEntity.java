package sk.mimi.cookbookspring.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Ingredient")
@NoArgsConstructor
@Builder
@Data
@EqualsAndHashCode
@AllArgsConstructor
public class IngredientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "recipe_id", referencedColumnName="id")
    private RecipeEntity recipe;

    private int weight;

    private WeightUnit weightUnit;

    @ManyToOne(targetEntity = FoodEntity.class, fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "food_id")
    private FoodEntity food;
}
