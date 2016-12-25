package ua.goit.java.jdbc.model;

import java.util.List;

/**
 * Created by Raketa on 24.12.2016.
 */
public interface EmployeeDao {

    void save(Employee employee);

    Employee load(Long id);

    List<Employee> findAll();
}
