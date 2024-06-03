package sk.mimi.cookbookspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import sk.mimi.cookbookspring.model.IngredientEntity;
@Repository
public interface IngredientRepository extends JpaRepository<IngredientEntity, Long>, JpaSpecificationExecutor<IngredientEntity> {
}
