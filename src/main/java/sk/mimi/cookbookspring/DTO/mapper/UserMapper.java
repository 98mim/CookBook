package sk.mimi.cookbookspring.DTO.mapper;

import org.mapstruct.Mapper;
import sk.mimi.cookbookspring.DTO.model.Ingredience;
import sk.mimi.cookbookspring.DTO.model.User;
import sk.mimi.cookbookspring.model.IngredienceEntity;
import sk.mimi.cookbookspring.model.UserEntity;

@Mapper
public interface UserMapper {
    UserEntity toEntity(User user);

    User fromEntity(UserEntity userEntity);
}
