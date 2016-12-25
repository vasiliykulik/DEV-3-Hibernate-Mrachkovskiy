package ua.goit.java.hibernate.dao;

import ua.goit.java.hibernate.model.Dish;

import java.util.List;

/**
 * Created by Raketa on 25.12.2016.
 */
public interface DishDao {
    // 71. Создадим Dao

    void save (Dish dish);

    // 102. То же самое сдесь
    Dish findByName(String name);

    List<Dish> findAll();
}
