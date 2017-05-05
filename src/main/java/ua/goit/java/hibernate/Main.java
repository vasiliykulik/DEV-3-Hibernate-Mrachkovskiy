package ua.goit.java.hibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.goit.java.hibernate.controllers.DishController;
import ua.goit.java.hibernate.controllers.EmployeeController;

/**
 * Created by Raketa on 22.12.2016.
 */
public class Main {
    private DishController dishController;

    private EmployeeController employeeController;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml", "hibernate-context.xml");

        context.getBean(Main.class).start();
    }

    private void start() {
        employeeController.createEmployee();
        dishController.createDish();

        employeeController.getAllEmployees().forEach(System.out::println);
        dishController.getAllDishes().forEach(System.out::println);


        System.out.println(employeeController.getEmployeesByName("John"));
    }

    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

    public void setDishController(DishController dishController) {
        this.dishController = dishController;
    }
}
