package sk.mimi.cookbookspring.DTO.mapper;

import org.mapstruct.Mapper;
import sk.mimi.cookbookspring.DTO.model.addRecipe.AddMethodRequest;
import sk.mimi.cookbookspring.model.MethodEntity;

@Mapper
public interface MethodMapper {

    MethodEntity toEntity(AddMethodRequest addMethodRequest);
}
