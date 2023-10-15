package sk.mimi.cookbookspring.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.mimi.cookbookspring.DTO.model.Recipe;

@RestController
public class BookController {

    @PostMapping
    public void insertRecipe(Recipe recipe){
        //todo

    }
}
