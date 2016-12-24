package ua.goit.java.jdbc.model.controllers;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.jdbc.model.Employee;
import ua.goit.java.jdbc.model.EmployeeDao;
import ua.goit.java.jdbc.model.Position;

/**
 * Created by Raketa on 24.12.2016.
 */
public class EmployeeController {
    private EmployeeDao employeeDao;

    // 30. Добавим поддержку транзакции, что бы Spring сделал
    @Transactional
    public void createEmployee() {
        // 26. Создадим Employee
        // 27. Что бы Hibernate зарегистрировал его в сессии - его надо передать
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("John");
        employee.setSurname("Smith");
        employee.setPosition(Position.WAITER);
        employee.setPhoneNumber("555-55-55");
        employee.setSalary(25000.0F);
        // 28. передаем
        employeeDao.save(employee);
    }

    // 37. Тоже самое здесь
    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
