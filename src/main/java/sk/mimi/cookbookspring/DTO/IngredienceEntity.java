package sk.mimi.cookbookspring.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sk.mimi.cookbookspring.model.WeightUnit;

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

    private FoodEntity food;
}
