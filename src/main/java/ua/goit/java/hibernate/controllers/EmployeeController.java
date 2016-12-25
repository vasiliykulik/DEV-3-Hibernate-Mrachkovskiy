package ua.goit.java.hibernate.controllers;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.hibernate.model.Employee;
import ua.goit.java.hibernate.dao.EmployeeDao;
import ua.goit.java.hibernate.model.Position;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Raketa on 24.12.2016.
 */

public class EmployeeController {

    private EmployeeDao employeeDao;

    @Transactional
    // 56. вынужден заменить void на Employee
    // 80. а здесь мы его сделаем void - дабы не было непоняток с id? когда мы выводим их на печать
    public void createEmployee() {

        // 54. Сделаем
        Set<Employee> allEmployees = new HashSet<>(employeeDao.findAll());

        Employee employee = new Employee();
        employee.setId(2L);
        employee.setName("John");
        employee.setSurname("Smith");
        employee.setPosition(Position.WAITER);
        employee.setPhoneNumber("555-55-55");
        employee.setSalary(25000.0F);

        // 54. Сделаем, иначе мы его создавать не будем
        if (!allEmployees.contains(employee)) {
            employeeDao.save(employee);
        }
        // 55. вернем в любом случае
        return employee;
    }
    // 78.
    @Transactional
    public List<Employee> getAllEmployees(){
        return employeeDao.findAll();
    }
    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;

    }
}
