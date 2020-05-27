package com.example.burger0524.dto;

import com.example.burger0524.vo.Ingredient;
import lombok.Data;


@Data
public class IngredientForm {

    private Integer id;
    private String name;
    private Integer price;

    public Ingredient toEntity() {
        return new Ingredient(id, name, price);
    }


}
