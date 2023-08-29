package com.workintech.s18g1.dao;

import com.workintech.s18g1.entity.Burger;
import com.workintech.s18g1.enums.BreadType;

import java.util.List;

public interface BurgerDao {

    Burger save(Burger burger);

    List<Burger> findAll();

    Burger findById(int id);
    List<Burger> findByPrice(double price);
    List<Burger> findByBreadType(String breadType);

    List<Burger> findByContent(String content);
    Burger update(Burger burger);

    void delete(Burger burger);


}
