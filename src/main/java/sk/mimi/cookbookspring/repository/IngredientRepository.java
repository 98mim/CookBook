package sk.mimi.cookbookspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.mimi.cookbookspring.model.IngredientEntity;
import sk.mimi.cookbookspring.model.RecipeEntity;

@Repository
public interface IngredientRepository extends JpaRepository<IngredientEntity, Long> {
}
