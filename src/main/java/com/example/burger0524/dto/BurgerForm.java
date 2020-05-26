package com.example.burger0524.dto;

import com.example.burger0524.vo.Burger;
import lombok.Data;

@Data
public class BurgerForm {

    private Integer id;
    private String name;
    private Integer price;

    public Burger toEntity() {
        return new Burger(id, name, price);
    }
}
