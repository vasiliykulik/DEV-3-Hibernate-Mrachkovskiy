package ua.goit.java.hibernate.controllers;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.hibernate.dao.DishDao;
import ua.goit.java.hibernate.model.Dish;
import ua.goit.java.hibernate.model.DishCategory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Raketa on 25.12.2016.
 */
public class DishController {
    // 76.
    private DishDao dishDao;

    // 75. Зададим соответствующие контроллеры
    // 90. Нет транзакции
    @Transactional
    public void createDish() {
        Dish plov = new Dish();
        plov.setName("Plov");
        plov.setCategory(DishCategory.MAIN);
        plov.setPrice(5.00F);
        plov.setWeight(300F);

        Dish salad = new Dish();
        salad.setName("Salad");
        salad.setCategory(DishCategory.SALAD);
        salad.setPrice(2.00F);
        salad.setWeight(200F);

        Dish potato = new Dish();
        potato.setName("Potato");
        potato.setCategory(DishCategory.SIDE_DISH);
        potato.setPrice(3.00F);
        potato.setWeight(100F);
// 78.
        Set<Dish> dishes = new HashSet<>(dishDao.findAll());
        if (!dishes.contains(plov)) {
            dishDao.save(plov);
        }
        if (!dishes.contains(salad)) {
            dishDao.save(salad);
        }
        if (!dishes.contains(potato)) {
            dishDao.save(potato);
        }

    }

    // 82.
    // 90. Нет транзакции
    @Transactional
    public List<Dish> getAllDishes(){
        return dishDao.findAll();
    }

    // 106. Давайте сделаем то же самое для Dish - протестируем
    @Transactional
    public Dish getDishByName(String name){
        return dishDao.findByName(name);
    }


    // 76.
    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }
}
