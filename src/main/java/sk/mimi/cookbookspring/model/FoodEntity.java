package sk.mimi.cookbookspring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class FoodEntity {
    @Id
    private Long id;

    private String name;
}
