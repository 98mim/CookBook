package sk.mimi.cookbookspring.DTO.mapper;

import org.mapstruct.Mapper;
import sk.mimi.cookbookspring.DTO.model.Ingredience;
import sk.mimi.cookbookspring.model.IngredienceEntity;

@Mapper
public interface IngredienceMapper {


    IngredienceEntity toEntity(Ingredience ingredience);

    Ingredience fromEntity(IngredienceEntity ingredienceEntity);
}
