package sk.mimi.cookbookspring.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.mimi.cookbookspring.model.RecipeEntity;

@Repository
@Transactional
public interface RecipeRepository extends JpaRepository<RecipeEntity, Long>, JpaSpecificationExecutor<RecipeEntity> {
    //Page<RecipeEntity> findAll(Pageable pageable);

    //Page<RecipeEntity> findAllByRecipeFilter(RecipeFilter filter, Pageable pageable);
    //Page<RecipeEntity> findAll(@Nullable Specification<RecipeEntity> spec, @NonNull Pageable pageable);

}
