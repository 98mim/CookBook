package sk.mimi.cookbookspring.model;

import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int weight;

    private WeightUnit weightUnit;

    @ManyToOne
    private FoodEntity food;
}
