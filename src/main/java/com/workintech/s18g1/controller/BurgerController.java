package com.workintech.s18g1.controller;


import com.workintech.s18g1.dao.BurgerDao;
import com.workintech.s18g1.entity.Burger;
import com.workintech.s18g1.enums.BreadType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/burger")
@Validated
public class BurgerController {

    private BurgerDao burgerDao;

    @Autowired
    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao;
    }

    @PostMapping("/")
    public Burger save(@Validated @RequestBody Burger burger) {
        return burgerDao.save(burger);
    }

    @GetMapping("/")
    public List<Burger> get() {
        return burgerDao.findAll();
    }


    @GetMapping("/{id}")
    public Burger find(int id) {
        return burgerDao.findById(id);
    }

    @GetMapping("/findByPrice/{price}")
    public List<Burger> findByPrice(@PathVariable double price) {
        return burgerDao.findByPrice(price);
    }


    @GetMapping("/findByBreadType/{breadType}")
    public List<Burger> findByBreadType(@PathVariable String BreadType) {
        return burgerDao.findByBreadType(BreadType);
    }

    @GetMapping("/findByContent/{contents}")
    public List<Burger> findByContent(@PathVariable String content) {
        return burgerDao.findByContent(content);
    }

    @PutMapping("/")
    public Burger update(@RequestBody Burger burger){
        return burgerDao.update(burger);
    }

    @DeleteMapping("/{id}")
    public Burger delete(@PathVariable int id){
        Burger burger = find(id);
        burgerDao.delete(burger);
        return burger;
    }

}
