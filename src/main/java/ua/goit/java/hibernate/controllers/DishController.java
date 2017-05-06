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

  private DishDao dishDao;

  @Transactional
  public void initDishes() {
    Dish plov = new Dish();
    plov.setName("Plov");
    plov.setCategory(DishCategory.MAIN);
    plov.setPrice(5.00F);
    plov.setWeight(300F);
    dishDao.save(plov);

    Dish salad = new Dish();
    salad.setName("Salad");
    salad.setCategory(DishCategory.SALAD);
    salad.setPrice(2.00F);
    salad.setWeight(200F);
    dishDao.save(salad);

    Dish potato = new Dish();
    potato.setName("Potato");
    potato.setCategory(DishCategory.SIDE_DISH);
    potato.setPrice(3.00F);
    potato.setWeight(100F);
    dishDao.save(potato);

  }

  @Transactional
  public List<Dish> getAllDishes() {
    return dishDao.findAll();
  }

  @Transactional
  public Dish getDishByName(String name) {
    return dishDao.findByName(name);
  }

  @Transactional
  public void removeAllDishes() {
    dishDao.removeAll();
  }

  public void setDishDao(DishDao dishDao) {
    this.dishDao = dishDao;
  }
}
