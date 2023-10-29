package sk.mimi.cookbookspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.mimi.cookbookspring.model.RecipeEntity;
import sk.mimi.cookbookspring.model.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
