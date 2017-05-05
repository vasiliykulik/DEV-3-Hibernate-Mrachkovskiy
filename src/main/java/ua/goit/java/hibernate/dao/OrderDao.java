package ua.goit.java.hibernate.dao;

import ua.goit.java.hibernate.model.Orders;

import java.util.List;

/**
 * Created by Raketa on 25.12.2016.
 */
public interface OrderDao {
  void save(Orders orders);
  List<Orders> findAllOrders();
}
