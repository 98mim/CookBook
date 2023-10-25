package sk.mimi.cookbookspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import sk.mimi.cookbookspring.model.RecipeEntity;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeEntity, Long>, JpaSpecificationExecutor<RecipeEntity> {

    //Page<RecipeEntity> findAllByRecipeFilter(RecipeFilter filter, Pageable pageable);
    //Page<RecipeEntity> findAll(@Nullable Specification<RecipeEntity> spec, @NonNull Pageable pageable);

}
