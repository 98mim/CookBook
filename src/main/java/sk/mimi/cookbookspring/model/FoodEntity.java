package sk.mimi.cookbookspring.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Food")
@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class FoodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
