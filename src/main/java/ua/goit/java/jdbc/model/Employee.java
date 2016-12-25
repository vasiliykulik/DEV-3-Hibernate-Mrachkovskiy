package ua.goit.java.jdbc.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.security.PrivateKey;

/**
 * Created by Raketa on 22.12.2016.
 */
@Entity
@Table(name = "employee")
public class Employee {

    @Id
// 50. Делегируем Hibernate strategy = "increment" - увеличивает на единичку
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    @Column(name = "position")
    private Position position;
    @Column(name = "salary")
    private Float salary;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", position=" + position +
                ", salary=" + salary +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }
}
