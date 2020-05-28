package com.example.burger0524.dto;

import com.example.burger0524.vo.Burger;
import com.example.burger0524.vo.Ingredient;
import lombok.Data;

import java.util.List;

@Data
public class BurgerForm {

    private Integer id;
    private String name;
    private Integer price;

    private List<Ingredient> ingredientList;

    public Burger toEntity() {
        return new Burger(id, name, price , ingredientList);
    }
}
