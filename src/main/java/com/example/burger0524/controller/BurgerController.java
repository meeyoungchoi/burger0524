package com.example.burger0524.controller;

import com.example.burger0524.dto.BurgerForm;
import com.example.burger0524.repository.BurgerRepository;
import com.example.burger0524.repository.IngredientRepository;
import com.example.burger0524.vo.Burger;
import com.example.burger0524.vo.Ingredient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
public class BurgerController {

    @Autowired
    private BurgerRepository burgerRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @GetMapping("/")
    public String index(Model model) {
        List<Burger> burgerList = burgerRepository.findAll();
        log.info(burgerList.toString());
        model.addAttribute("burgerList", burgerList);
        return "burgers/index";
    }

    @GetMapping("/burgers/init")
    public String init() {
        List<Burger> burgerList = new ArrayList<>();
        burgerList.add(new Burger(null, "새우버거", 3000, null));
        burgerList.add(new Burger(null, "치킨버거", 3500, null));
        burgerList.add(new Burger(null, "불고기버거", 3500, null));

        burgerRepository.saveAll(burgerList);

        List<Ingredient> ingredientList = new ArrayList<>();
        ingredientList.add(new Ingredient(null, "야채", 300));
        ingredientList.add(new Ingredient(null, "소스", 100));
        ingredientList.add(new Ingredient(null, "패티", 800));
        ingredientList.add(new Ingredient(null, "토마토", 300));

        ingredientRepository.saveAll(ingredientList);

        return "redirect:/";
    }


    @GetMapping("/burgers/new")
    public String newBurger(Model model) {
        List<Ingredient> ingredientList = ingredientRepository.findAll();
        model.addAttribute("ingredientList", ingredientList);
        return "burgers/new";
    }

    @PostMapping("/burgers")
    public String create(BurgerForm form) {
        log.info(form.toString());

        Burger burger = form.toEntity();
        log.info(burger.toString());

        Burger saved = burgerRepository.save(burger);
        log.info(saved.toString());

        return "redirect:/";
    }

    @GetMapping(value ="/burgers/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Burger burger = burgerRepository.findById(id).orElse(null);
        model.addAttribute("burger", burger);
        return "burgers/edit";
    }

    @PostMapping(value = "/burgers/{id}")
    public String update(BurgerForm form) {
        log.info(form.toString());

        Burger burger = form.toEntity();
        log.info(burger.toString());

        Burger saved = burgerRepository.save(burger);
        log.info(saved.toString());

        return "redirect:/";
    }

    @GetMapping(value = "/burgers/delete/{id}")
    public String delete(@PathVariable Integer id) {
        burgerRepository.deleteById(id);
        log.info(id + "번 삭제완료");
        return "redirect:/";
    }

    @GetMapping(value = "/burgers/show/{id}")
    public String show(@PathVariable Integer id, Model model) {
        Burger burger = burgerRepository.findById(id).orElse(null);
        model.addAttribute("burger", burger);
        return "burgers/show";
    }

}
