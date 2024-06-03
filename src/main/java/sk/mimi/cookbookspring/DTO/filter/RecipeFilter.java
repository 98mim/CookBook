package sk.mimi.cookbookspring.DTO.filter;


import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.ObjectUtils;
import sk.mimi.cookbookspring.model.CourseType;
import sk.mimi.cookbookspring.model.Difficulty;
import sk.mimi.cookbookspring.model.IngredientEntity;
import sk.mimi.cookbookspring.model.RecipeEntity;

import java.util.ArrayList;
import java.util.List;


@Data
public class RecipeFilter {
    private String name;
    private List<String> ingredients;
    private Integer overallTime;
    private Difficulty difficulty;
    private CourseType courseType;
    private Integer cookTime;

    // Getters and setters for the filter criteria (name, ingredients, prepTime, cookTime)

    public Specification<RecipeEntity> buildSpecification() {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (!ObjectUtils.isEmpty(name)) {
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + name + "%"));
            }

            if (ingredients != null && !ingredients.isEmpty()) {
                Join<RecipeEntity, IngredientEntity> ingredientJoin = root.join("ingredients");
                predicates.add(ingredientJoin.join("food").get("name").in(ingredients));
            }

            /*if (prepTime != null) {
                predicates.add(criteriaBuilder.equal(root.get("prepTime"), prepTime));
            }*/
            if (overallTime != null && overallTime > 0) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("overallTime"), overallTime));
            }

            if (cookTime != null && cookTime > 0) {
                predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("cookTime"), cookTime));
            }

            if (!ObjectUtils.isEmpty(difficulty)) {
                predicates.add(criteriaBuilder.equal(root.get("difficulty"), difficulty));
            }

            if (!ObjectUtils.isEmpty(courseType)) {
                predicates.add(criteriaBuilder.equal(root.get("courseType"), courseType));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));

        };
    }
}
