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

    private EmployeeController employeeController;

    // 79. и сеттер на него
    private DishController dishController;

    // 127.
    private OrderController orderController;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext
                ("application-context.xml", "hibernate-context.xml");
        context.getBean(Main.class).start();

    }

    private void start() {
        employeeController.createEmployee();

        dishController.createDish();
        // 127.
        List<String> dishes1 = new ArrayList<>();
        dishes1.add("Potato");
        dishes1.add("Salad");

        List<String> dishes2 = new ArrayList<>();
        dishes2.add("Plov");
        dishes2.add("Salad");

        orderController.createOrder("John",dishes1,1);
        orderController.createOrder("John",dishes2,2);
        // 128.
        orderController.getAllOrders().forEach(System.out::println);
        // 140. Lazy ошибка, он не будет ничего возвращать, будет выполнять то что мы пытались сделать в пределах транзакции

        /*orderController.printAllOrders().forEach(System.out::println);*/

        employeeController.getAllEmployees().forEach(System.out::println);
        // 83. и В main сделаем так
        dishController.getAllDishes().forEach(System.out::println);
        //104. и проверим
        System.out.println(employeeController.getEmployeeByName("John"));

        // 107.
        System.out.println(dishController.getDishByName("Plov"));


    }


    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public void setDishController(DishController dishController) {
        this.dishController = dishController;
    }

    // 127.


    public void setOrderController(OrderController orderController) {
        this.orderController = orderController;
    }
}
