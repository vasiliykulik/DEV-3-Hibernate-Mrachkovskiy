package ua.goit.java.hibernate.controllers;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.hibernate.model.Employee;
import ua.goit.java.hibernate.dao.EmployeeDao;
import ua.goit.java.hibernate.model.Position;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Raketa on 24.12.2016.
 */

public class EmployeeController {

    private EmployeeDao employeeDao;

    @Transactional
    public Employee createEmployee(){
        Set<Employee> allEmployees = new HashSet<>(employeeDao.findAll());

        Employee employee = new Employee();
        employee.setName("John");
        employee.setSurname("Smith");
        employee.setPosition(Position.WAITER);
        employee.setPhoneNumber("555-55-55");
        employee.setSalary(25000.0F);

        if(!allEmployees.contains(employee)){
            employeeDao.save(employee);
        }
        return employee;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}
