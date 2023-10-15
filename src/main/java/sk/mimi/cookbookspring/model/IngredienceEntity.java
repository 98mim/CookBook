package sk.mimi.cookbookspring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Builder
@Data
@AllArgsConstructor
public class IngredienceEntity {
    @Id
    private Long id;

    private int weight;

    private WeightUnit weightUnit;

    @ManyToOne
    private FoodEntity food;
}
