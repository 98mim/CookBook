package sk.mimi.cookbookspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import sk.mimi.cookbookspring.model.FoodEntity;
import sk.mimi.cookbookspring.model.RecipeEntity;

import java.util.Optional;

@Repository
public interface FoodRepository extends JpaRepository<FoodEntity, Long>, JpaSpecificationExecutor<FoodEntity> {
    Optional<FoodEntity> findFirstByName(String name);
}
