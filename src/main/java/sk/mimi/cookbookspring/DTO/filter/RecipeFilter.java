package sk.mimi.cookbookspring.DTO.filter;


import jakarta.persistence.criteria.Predicate;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;
import sk.mimi.cookbookspring.model.RecipeEntity;

import java.util.ArrayList;
import java.util.List;


@Data
public class RecipeFilter {
    private String name;
    private List<String> ingredients;
    private Integer prepTime;
    private Integer cookTime;

    // Getters and setters for the filter criteria (name, ingredients, prepTime, cookTime)

    public Specification<RecipeEntity> buildSpecification() {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (name != null) {
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + name + "%"));
            }

            /*if (ingredients != null && !ingredients.isEmpty()) {
                Join<RecipeEntity, IngredienceEntity> ingredientJoin = root.join("ingredients");
                predicates.add(ingredientJoin.get("food").get("name").in(ingredients));
            }*/

            if (prepTime != null) {
                predicates.add(criteriaBuilder.equal(root.get("prepTime"), prepTime));
            }

            if (cookTime != null) {
                predicates.add(criteriaBuilder.equal(root.get("cookTime"), cookTime));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));

        };
    }
}
