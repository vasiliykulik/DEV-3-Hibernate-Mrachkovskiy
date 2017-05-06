package ua.goit.java.hibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.goit.java.hibernate.controllers.DishController;
import ua.goit.java.hibernate.controllers.EmployeeController;
import ua.goit.java.hibernate.controllers.OrderController;

/**
 * Created by Raketa on 22.12.2016.
 */
public class Main {
  private DishController dishController;
  private EmployeeController employeeController;
  private OrderController orderController;

  private boolean reInit;

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml", "hibernate-context.xml");
    context.getBean(Main.class).start();
  }

  public void init() {
    if (reInit) {
      orderController.removeAllOrders();
      dishController.removeAllDishes();
      employeeController.removeAllEmployee();

      employeeController.initEmployees();
      dishController.initDishes();
      orderController.initOrders();
    }
  }

  public void start() {
    employeeController.getAllEmployees().forEach(System.out::println);
    employeeController.printAllEmpoyees();
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

  public void setReInit(boolean reInit) {
    this.reInit = reInit;
  }
}

