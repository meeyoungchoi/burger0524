package com.example.burger0524.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Burger {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private Integer price;




}
