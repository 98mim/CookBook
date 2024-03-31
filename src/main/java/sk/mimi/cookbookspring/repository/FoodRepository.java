package sk.mimi.cookbookspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.mimi.cookbookspring.model.FoodEntity;
import sk.mimi.cookbookspring.model.RecipeEntity;

import java.util.Optional;

@Repository
public interface FoodRepository extends JpaRepository<FoodEntity, Long> {
    Optional<FoodEntity> findFirstByName(String name);
}
