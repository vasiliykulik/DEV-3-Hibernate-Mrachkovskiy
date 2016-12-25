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

    @Transactional
    public void createEmployee() {
        Employee employee = new Employee();
        employee.setId(2L);
        employee.setName("John");
        employee.setSurname("Smith");
        employee.setPosition(Position.WAITER);
        employee.setPhoneNumber("555-55-55");
        employee.setSalary(25000.0F);

        employeeDao.save(employee);
    }


    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
