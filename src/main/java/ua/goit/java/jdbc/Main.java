package ua.goit.java.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.goit.java.jdbc.model.controllers.EmployeeController;

/**
 * Created by Raketa on 22.12.2016.
 */
public class Main {

    private EmployeeController employeeController;

    // 21. напишем маленькое приложение
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml", "hibernate-context.xml");
// 22. Зарегистрируем Main методом бином, сделаем стартовый пойнт
        Main main = applicationContext.getBean(Main.class);
        main.start();
    }
// 24. как и с Jdbc  - хорошим тоном будет выделение объектов работающих с БД
//  или с Hibernate в отдельные объекты DataAccessObjects

    private void start() {
// 31.
        employeeController.createEmployee();
    }

    // 31. добавим setter
    public void setEmployeeController(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }
    // 40. Похоже на правду
}
