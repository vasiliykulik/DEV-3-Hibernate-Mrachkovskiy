package ua.goit.java.hibernate.dao;

import ua.goit.java.hibernate.model.Employee;

import java.util.List;

/**
 * Created by Raketa on 24.12.2016.
 */
public interface EmployeeDao {

    void save(Employee employee);

    Employee load(Long id);

    List<Employee> findAll();

    // 51. добавим меотд который будет удалять
    void remove(Employee employee);
}