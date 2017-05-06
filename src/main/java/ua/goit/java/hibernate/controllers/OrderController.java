package ua.goit.java.hibernate.controllers;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.hibernate.dao.DishDao;
import ua.goit.java.hibernate.dao.EmployeeDao;
import ua.goit.java.hibernate.dao.OrderDao;
import ua.goit.java.hibernate.model.Dish;
import ua.goit.java.hibernate.model.DishCategory;
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
    List<String> dishes1 = new ArrayList<>();
    dishes1.add("Plov");
    dishes1.add("Salad");

    createOrder("John", dishes1, 1);

    List<String> dishes2 = new ArrayList<>();
    dishes2.add("Potato");
    dishes2.add("Salad");

    createOrder("John", dishes2, 2);
    List<String> dishes3 = new ArrayList<>();
    dishes3.add("Plov");
    dishes3.add("Potato");

    createOrder("Mary", dishes3, 3);

    orderDao.save(createOderWithIceCream());
/*    String waiterName = "John";
    List<String> dishes = new ArrayList<>();
    dishes.add("Plov");
    dishes.add("Salad");
    int tableNumber = 2;
    Order order = new Order();
    order.setWaiter(employeeDao.findByName(waiterName));
    order.setDishes(createDishes(dishes));
    order.setTableNumber(tableNumber);
    order.setOrderDate(new Date());
    orderDao.save(order);*/
  }

  private Order createOderWithIceCream() {
    List<Dish> dishes4 = new ArrayList<>();

    Dish iceCream = new Dish();
    iceCream.setName("Ice Cream");
    iceCream.setCategory(DishCategory.DESSERT);
    iceCream.setPrice(3.0F);
    iceCream.setWeight(100.0F);
    dishes4.add(iceCream);

    Order order = new Order();
    order.setWaiter(employeeDao.findByName("Mary"));
    order.setDishes(dishes4);
    order.setTableNumber(4);
    order.setOrderDate(new Date());
    return order;
  }

  @Transactional
  public void createOrder(String waiterName, List<String> dishes, int tableNumber) {
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
