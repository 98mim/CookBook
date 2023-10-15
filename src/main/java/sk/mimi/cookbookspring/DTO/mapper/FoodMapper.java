package sk.mimi.cookbookspring.DTO.mapper;

import org.mapstruct.Mapper;
import sk.mimi.cookbookspring.DTO.model.Food;
import sk.mimi.cookbookspring.model.FoodEntity;

@Mapper(componentModel = "spring")
public interface FoodMapper {

    FoodEntity toEntity(Food food);

    Food fromEntity(FoodEntity foodEntity);
}
