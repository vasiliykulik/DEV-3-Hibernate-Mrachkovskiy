package main.java.ua.goit.java.jdbc.model;

import javax.persistence.*;
import java.security.PrivateKey;

/**
 * Created by Raketa on 22.12.2016.
 */
// 1. создадим модельный класс
// 5. Объясним Hibernate Анотируем - что это сущность (любому JPA framework)
@Entity
// 6. Объясним Hibernate на какую табличку мапится класс (можем не указать Hibernate сам попробует найти)
@Table(name = "employee")
public class Employee {
    // 7. Укажем что будет Id (можем не указать Hibernate сам попробует найти - после рефакторинг БД - все может сломаться)
    @Id
    // 8. Смаппим поле (Рефакторинг кода происходит чаще чем БД)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    // 9. Вот здесь поля не совпадают и маппинг нам нужен обязательно
    @Column(name = "phone_number")
    private String phoneNumber;
    // 2. создадим enum
    // 10. Position - это enum  - и нам нужно объяснить Hibernate (используем Enumerated,
    // и укажем EnumType. есть две опции ORDINAL - порядковый номер Enum (нумерация с 0), второй вариант STRING
    // имя instance enum. Использовать String - что бы проблем не было с рефакторингом, например всунете ENUM всередину,
    // чисто для читаемости кода. Цифра - непрезентабельны. И скорее всего bottle neck будет вдругом вместе)
    @Enumerated(EnumType.STRING)
    @Column(name = "position")
    private Position position;
    @Column(name = "salary")
    private Float salary;
    // 3. создадим sql таблицу
    // 4. Как же нам теперь смапить поля на табличку - есть несколько способов -
    // посмотрим как сделать Аннотациями( можна делять в xml)
    // 11. Вот в принципе и весь mapping, это mapping row type (по сути примитивов, простых объектов (embedded - String)
    // те которые грубоговоря находятся в отношении КОМПОЗИЦИИ с нашим объектов)
}
