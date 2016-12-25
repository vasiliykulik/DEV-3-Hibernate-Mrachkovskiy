package ua.goit.java.jdbc.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Raketa on 25.12.2016.
 */
@Entity
@Table(name = "orders")
public class Order {
    // 61. более сложный

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private long id;

    // 62. Появляется связь с другой Entity, перое слово относится к нашей сущности
    // Много ордеров к одному Employee. В таблицу заносим employee_id
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee waiter;


    // 63. КОНФИгурируем таблицу
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "dish_to_order",
            joinColumns = @JoinColumn(name = "dish_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id")
    )
    private List<Dish> dishes;

    @Column(name  ="table_number")
    private int tableNumber;

    @Column(name = "order_date")
    private Date orderDate;

}
