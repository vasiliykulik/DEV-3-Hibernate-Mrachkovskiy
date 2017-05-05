package ua.goit.java.hibernate.dao;

import ua.goit.java.hibernate.model.Employee;

import java.util.List;

/**
 * Created by Raketa on 24.12.2016.
 */
public interface EmployeeDao {
  // 24. как и с Jdbc  - хорошим тоном будет выделение объектов работающих с БД
//  или с Hibernate в отдельные объекты DataAccessObjects
  void save(Employee employee);

  Employee load(Long id);

  List<Employee> findAll();

  void remove(Employee employee);
}
