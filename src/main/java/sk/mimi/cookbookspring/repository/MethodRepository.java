package sk.mimi.cookbookspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.mimi.cookbookspring.model.MethodEntity;

@Repository
public interface MethodRepository extends JpaRepository<MethodEntity, Long> {
}
