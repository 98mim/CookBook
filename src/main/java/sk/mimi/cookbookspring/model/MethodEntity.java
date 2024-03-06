package sk.mimi.cookbookspring.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Method")
@NoArgsConstructor
@Builder
@Data
@EqualsAndHashCode
@AllArgsConstructor
public class MethodEntity {
    @Id
    private Long id;

    @Column(name = "order_number")
    private int order;

    private String body;

    @EqualsAndHashCode.Exclude
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "recipe_id", referencedColumnName="id")
    private RecipeEntity recipe;
}
