/*
package ua.goit.java.hibernate.controllers;

import org.springframework.transaction.annotation.Transactional;
import ua.goit.java.hibernate.dao.DishDao;
import ua.goit.java.hibernate.dao.EmployeeDao;
import ua.goit.java.hibernate.dao.OrderDao;
import ua.goit.java.hibernate.model.Dish;
import ua.goit.java.hibernate.model.Orders;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

*/
/**
 * Created by Raketa on 25.12.2016.
 *//*

public class OrderController {
    // 95. Свяжем всех этих товарищей между собой,

    private EmployeeDao employeeDao;
    private DishDao dishDao;
    private OrderDao orderDao;

    // 113. Сразу объявим
    @Transactional
    public void createOrder(String waiterName, List<String> dishes, int tableNumber) {


        // 96. похожие запросы могут приходить с application, но в более User Friendly
        // 97. Нам нужно находить объекты по каким то другим полям, и это будет делаться через EmployeeDao
        // 110. Можем приступить к созданию Orders
        Orders orders = new Orders();
        orders.setWaiter(employeeDao.findByName(waiterName));
        orders.setDishes(createDishes(dishes));
        // 112. далее
        orders.setTableNumber(tableNumber);
        orders.setOrderDate(new Date());
// 120. Set <Orders> создавать не будем
        // 130. Забыли заперсистить
        orderDao.save(orders);
    }

    // 128. Добавим метод для вывода всех ордеров
    @Transactional
    public List<Orders> getAllOrders() {
        return orderDao.findAllOrders();
    }
// 140. недописали
 */
/*   @Transactional
    public void printAllOrders(){
        getAllOrders().forEach(Sys);
    }*//*


    private List<Dish> createDishes(List<String> dishes) {
        List<Dish> result = new ArrayList<>();
        for (String dishName : dishes) {
            result.add(dishDao.findByName(dishName));
        }
        return result;
    }
    // 111. надо добавить setters

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void setDishDao(DishDao dishDao) {
        this.dishDao = dishDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
}
*/
