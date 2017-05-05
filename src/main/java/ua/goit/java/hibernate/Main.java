package ua.goit.java.hibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.goit.java.hibernate.controllers.DishController;
import ua.goit.java.hibernate.controllers.EmployeeController;
import ua.goit.java.hibernate.controllers.OrderController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raketa on 22.12.2016.
 */
public class Main {
  private DishController dishController;
  private EmployeeController employeeController;
  private OrderController orderController;

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml", "hibernate-context.xml");
    context.getBean(Main.class).start();
  }

  private void start() {
    employeeController.createEmployee();
    dishController.createDish();
/*    employeeController.getAllEmployees().forEach(System.out::println);
    dishController.getAllDishes().forEach(System.out::println);
    System.out.println(employeeController.getEmployeesByName("John"));
    System.out.println(dishController.getDishByName("Plov"));*/
    List<String> dishes1 = new ArrayList<>();
    dishes1.add("Plov");
    dishes1.add("Salad");
    orderController.createOrder("John", dishes1, 1);
    List<String> dishes = new ArrayList<>();
    dishes.add("Potato");
    dishes.add("Salad");
    orderController.createOrder("John", dishes, 2);
    orderController.getAllOrders().forEach(System.out::println);
    orderController.printAllOrders();
  }

  public void setEmployeeController(EmployeeController employeeController) {
    this.employeeController = employeeController;
  }

  public void setDishController(DishController dishController) {
    this.dishController = dishController;
  }

  public void setOrderController(OrderController orderController) {
    this.orderController = orderController;
  }
}

