package ua.goit.java.hibernate.controllers;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.hibernate.model.Employee;
import ua.goit.java.hibernate.dao.EmployeeDao;
import ua.goit.java.hibernate.model.Position;
import ua.goit.java.hibernate.model.Waiter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Raketa on 24.12.2016.
 */

public class EmployeeController {

  private EmployeeDao employeeDao;


  @Transactional
  public void initEmployees() {

    Waiter john = new Waiter();
    john.setName("John");
    john.setSurname("Smith");
    john.setPhoneNumber("555-55-55");
    john.setPosition(Position.WAITER);
    john.setSalary(25000.0F);
    employeeDao.save(john);

    Waiter mary = new Waiter();
    mary.setName("Mary");
    mary.setSurname("Smith");
    mary.setPhoneNumber("555-55-55");
    mary.setPosition(Position.WAITER);
    mary.setSalary(25000.0F);
    employeeDao.save(mary);
  }

  @Transactional
  public void printEmployee(Long id){
    System.out.println(employeeDao.load(id));
    System.out.println(employeeDao.load(id));
  }

  @Transactional
  public void createEmployee() {
    Set<Employee> allEmployees = new HashSet<>(employeeDao.findAll());

    Employee employee = new Employee();
    employee.setName("John");
    employee.setSurname("Smith");
    employee.setPosition(Position.WAITER);
    employee.setPhoneNumber("555-55-55");
    employee.setSalary(25000.0F);
      employeeDao.save(employee);
  }

  @Transactional
  public List<Employee> getAllEmployees() {
    return employeeDao.findAll();
  }

  @Transactional
  public Employee getEmployeesByName(String name) {
    return employeeDao.findByName(name);
  }

  @Transactional
  public void removeAllEmployee() {
    employeeDao.removeAll();
  }

  @Transactional
  public void printAllEmpoyees(){
    employeeDao.findAll().forEach(System.out::println);
  }

  public void setEmployeeDao(EmployeeDao employeeDao) {
    this.employeeDao = employeeDao;
  }
}
