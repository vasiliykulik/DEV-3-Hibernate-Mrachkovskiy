package ua.goit.java.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.goit.java.jdbc.model.controllers.EmployeeController;

/**
 * Created by Raketa on 22.12.2016.
 */
public class Main {

    private EmployeeController employeeController;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml", "hibernate-context.xml");
        Main main = applicationContext.getBean(Main.class);
        main.start();
    }

    private void start() {
        employeeController.createEmployee();
    }


    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }
}
