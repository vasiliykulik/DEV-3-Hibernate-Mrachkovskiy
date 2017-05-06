package ua.goit.java.hibernate.controllers;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.hibernate.dao.DishDao;
import ua.goit.java.hibernate.dao.EmployeeDao;
import ua.goit.java.hibernate.dao.OrderDao;
import ua.goit.java.hibernate.model.Dish;
import ua.goit.java.hibernate.model.Order;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderController {

  private EmployeeDao employeeDao;
  private DishDao dishDao;
  private OrderDao orderDao;

  @Transactional
  public void initOrders() {
    String waiterName = "John";
    List<String> dishes = new ArrayList<>();
    dishes.add("Plov");
    dishes.add("Salad");
    int tableNumber = 2;
    Order order = new Order();
    order.setWaiter(employeeDao.findByName(waiterName));
    order.setDishes(createDishes(dishes));
    order.setTableNumber(tableNumber);
    order.setOrderDate(new Date());
    orderDao.save(order);
  }

  // 128. Добавим метод для вывода всех ордеров
  @Transactional
  public List<Order> getAllOrders() {
    return orderDao.findAllOrders();
  }

  @Transactional
  public void printAllOrders() {
    getAllOrders().forEach(System.out::println);
  }

  @Transactional
  public void removeAllOrders() {
    orderDao.removeAll();
  }

  @Transactional
  private List<Dish> createDishes(List<String> dishes) {
    List<Dish> result = new ArrayList<>();
    for (String dishName : dishes) {
      result.add(dishDao.findByName(dishName));
    }
    return result;
  }

  public void setEmployeeDao(EmployeeDao employeeDao) {
    this.employeeDao = employeeDao;
  }

  public void setDishDao(DishDao dishDao) {
    this.dishDao = dishDao;
  }

  public void setOrderDao(OrderDao orderDao) {
    this.orderDao = orderDao;
  }
}
